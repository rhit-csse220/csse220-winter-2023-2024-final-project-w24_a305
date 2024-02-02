package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class MainApp {
	
	public MainApp() {
		
		
		
	}
	
	
	private static void runApp() throws FileNotFoundException, IOException, InvalidLevelFormat {
		System.out.println("Write your cool arcade game here!");
		System.out.println("Testing");
		JFrame frame = new JFrame();
		frame.setSize(1000, 400);
		frame.setTitle("Jetpack Joyride");
		Game game = new Game();
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_U) {
					frame.remove(game.getCurrentLevel());
					frame.setVisible(false);
					game.goUpLevel();
					frame.add(game.getCurrentLevel());
					frame.setVisible(true);
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					frame.remove(game.getCurrentLevel());
					frame.setVisible(false);
					game.goBackLevel();
					frame.add(game.getCurrentLevel());
					frame.setVisible(true);
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.getCurrentLevel().setSpacePressed(true);
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					game.getCurrentLevel().setSpacePressed(false);
				}
			}
			
		});
		frame.add(game.getCurrentLevel());
	/*	
		Timer t = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				advanceOneTick();
				
			}
			public void advanceOneTick() {
				level.updateState();
				level.repaint();
			}
		});
	
		t.start();
	*/
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		MainApp mainApp = new MainApp();
		
		try {
			runApp();
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found :(");
		} catch (InvalidLevelFormat e) {
			System.err.println(e.getErrMessage());
		}
		
		
				
	} // main

}