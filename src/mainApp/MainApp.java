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
	
	
	private static void runApp(String filename) throws FileNotFoundException, IOException {
		System.out.println("Write your cool arcade game here!");
		System.out.println("Testing");
		
		JFrame frame = new JFrame();
		frame.setSize(1000, 400);
		frame.setTitle("Jetpack Joyride");
		System.out.println(filename);
		Level level1 = new Level(filename);
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					level1.setSpacePressed(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					level1.setSpacePressed(false);
				}
			}
			
		});
		frame.add(level1);
		
		Timer t = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				advanceOneTick();
				
			}
			public void advanceOneTick() {
				level1.updateState();
				level1.repaint();
			}
		});
		t.start();
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
			runApp("Level2.txt");
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found :(");
		}
		
		
				
	} // main

}