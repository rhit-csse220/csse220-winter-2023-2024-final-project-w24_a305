package mainApp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

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
		//System.out.println(filename);
		Level level1 = new Level(filename);
		frame.add(level1);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) throws IOException {
		MainApp mainApp = new MainApp();
		Scanner s = new Scanner(System.in);
		String filename = null;
		boolean isDone = false;
		
		while (!isDone) {
			try {
				System.out.println("What level should I load?");
				filename = s.nextLine();
				runApp(filename);
				isDone = true;
			} catch (FileNotFoundException e) {
				System.err.println("Level " + filename + " not found");
				System.out.println(e);
			}
		}
		s.close();
		System.out.println("Game Closed");
				
	} // main

}