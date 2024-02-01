package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			runApp("trialRun.txt");
		} catch (FileNotFoundException e) {
			System.err.println("File Not Found :(");
		}
		
		
				
	} // main

}