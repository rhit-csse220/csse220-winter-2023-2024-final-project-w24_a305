package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Timer;

public class Game {
	
	private ArrayList<Level> levels;
	private Level currentLevel;

	public Game() throws FileNotFoundException, IOException, InvalidLevelFormat {
		
		this.levels = new ArrayList<Level>();
		
		FileReader f = new FileReader("Level1.txt");
		Scanner s = new Scanner(f);
		
		
		try {
			this.levels.add(new Level("Level1.txt"));
			this.levels.add(new Level("Level2.txt"));
		}catch (InvalidLevelFormat e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		this.currentLevel = this.levels.get(0);
		
		update();
		
	}
	
	public void update() {
		Timer t = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				advanceOneTick();
				
			}
			public void advanceOneTick() {
				currentLevel.updateState();
				currentLevel.repaint();
			}
		});
		t.start();
	}
	
	public void goBackLevel() {
		if (this.levels.indexOf(this.currentLevel) > 0) {
			this.currentLevel.restartBarrySteakfries();
			this.currentLevel = this.levels.get(this.levels.indexOf(this.currentLevel) - 1);
		}
	}

	public void goUpLevel() {
		if (this.levels.indexOf(this.currentLevel) < this.levels.size() - 1) {
			this.currentLevel.restartBarrySteakfries();
			this.currentLevel = this.levels.get(this.levels.indexOf(this.currentLevel) + 1);
		}
	}
	
	public Level getCurrentLevel() {
		return this.currentLevel;
	}
	
}
