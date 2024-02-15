package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 * Class: Game
 * <br>Purpose: To store levels and initiate them. Has methods to swap between levels. Checks if files 
 * are correctly formatted.
 */

public class Game {
	
	private ArrayList<Level> levels;
	private Level currentLevel;
	private JLabel health;
	private JLabel coins;
	private JPanel stats;
	private int heroHealth;
	private int heroCoins;

	public Game() throws FileNotFoundException, IOException, InvalidLevelFormat {
		
		this.levels = new ArrayList<Level>();
		this.health = new JLabel();
		this.coins = new JLabel();
		this.stats = new JPanel();
		this.heroHealth = 0;
		this.heroCoins = 0;
		
		stats.add(health);
		stats.add(coins);
		
		
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
	
	/**
	 * Creates a timer to update the current level's components (Hero, Coin, Barrier, etc.)
	 */
	
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
				
				health.setText("Health: " + currentLevel.handleReturnHealth());
				coins.setText("Coins: " + currentLevel.handleReturnCoins());
			}
		});
		t.start();
	}
	
	/**
	 * Changes the current level to the one before it in the levels ArrayList.
	 */
	public void goBackLevel() {
		if (this.levels.indexOf(this.currentLevel) > 0) {
			System.out.println();
			this.heroHealth = this.currentLevel.handleReturnHealth();
			this.heroCoins = this.currentLevel.handleReturnCoins();
			this.currentLevel.restart();
			this.currentLevel = this.levels.get(this.levels.indexOf(this.currentLevel) - 1);
			this.currentLevel.handleHardSetHeroHealth(this.heroHealth);
			this.currentLevel.handleHardSetHeroCoins(this.heroCoins);
			this.currentLevel.restart();
		}
	}
	/**
	 * Changes the current level to the one after it in the levels ArrayList
	 */
	public void goUpLevel() {
		if (this.levels.indexOf(this.currentLevel) < this.levels.size() - 1) {
			this.heroHealth = this.currentLevel.handleReturnHealth();
			this.heroCoins = this.currentLevel.handleReturnCoins();
			this.currentLevel.restart();
			this.currentLevel = this.levels.get(this.levels.indexOf(this.currentLevel) + 1);
			this.currentLevel.handleHardSetHeroHealth(this.heroHealth);
			this.currentLevel.handleHardSetHeroCoins(this.heroCoins);
			this.currentLevel.restart();
		}
	}
	/**
	 * Changes the current level to the one in the index specified in the levels ArrayList
	 * @param int index
	 */
	public void goToLevel(int index) {
		
		this.currentLevel.restart();
		this.currentLevel = this.levels.get(index);
		this.currentLevel.restart();
		this.currentLevel.handleHardSetHeroHealth(3);
		this.currentLevel.handleHardSetHeroCoins(0);
		
	}
	
	/**
	 * Returns the current level
	 * @return this.currentLevel
	 */
	public Level getCurrentLevel() {
		return this.currentLevel;
	}
	
	/**
	 * Returns the index of the current level in the levels ArrayList
	 * @return the index of the current level
	 */
	
	public int getLevelNum() {
		return this.levels.indexOf(this.currentLevel);
	}
	
	/**
	 * Adds the number of hearts and coins the hero has collected to the top of the frame in MainApp
	 * @param frame
	 */
	
	public void insertStats(JFrame frame) {
		
		stats.setSize(1000, 20);
		frame.add(stats, BorderLayout.NORTH);
		
	}
	
	/**
	 * Restarts the game by changing the level to the first one and restarting positions of gameObjects and hero health/coins.
	 */
	public void restartGame() {
		this.currentLevel = this.levels.get(0);
		this.currentLevel.restart();
		this.getCurrentLevel().restartHeroStats();
		
	}
	
}
