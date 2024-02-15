package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @author W24_A305
 * <br>Purpose: Top level class for CSSE220 Project containing main method.
 * 				Creates frame & the Game class. Also handles all the key listeners.
 * <br>Restrictions: None
 */
public class MainApp {
	
	public MainApp() {
		
		
		
	}
	/**
	 * 
	 * Initializes frame & game. handles key listeners. Moves up and down levels and causes Barry Steakfries to fly up.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws InvalidLevelFormat
	 */
	
	private static void runApp() throws FileNotFoundException, IOException, InvalidLevelFormat {
		boolean restartWindowOpen = false;
		System.out.println("Write your cool arcade game here!");
		System.out.println("Testing");
		JFrame frame = new JFrame();
		frame.setSize(1000, 430);
		frame.setTitle("Jetpack Joyride");
		Game game = new Game();
		JFrame gameWonFrame = new JFrame();
		gameWonFrame.setSize(200,200);
		JPanel buttons = new JPanel();
		JButton restart = new JButton("Restart Game");
		JButton exit = new JButton("Close Game");
		buttons.add(restart);
		buttons.add(exit);
		gameWonFrame.add(buttons);
		game.insertStats(frame);
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				game.goToLevel(0);
				gameWonFrame.setVisible(false);
				frame.add(game.getCurrentLevel());
			}
			
		});
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
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
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameWonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (!game.getCurrentLevel().getGameOver()) {
			//System.out.println(game.getCurrentLevel().getLevelWon());
			System.out.println(game.getLevelNum());
			if (game.getLevelNum() == 0) {
				restartWindowOpen = false;
			}
			if (game.getCurrentLevel().getLevelWon()) {
				
				if (game.getLevelNum() == 0) {
					game.getCurrentLevel().setLevelWon(false);
					frame.remove(game.getCurrentLevel());
					frame.setVisible(false);
					game.goUpLevel();
					frame.add(game.getCurrentLevel());
					frame.setVisible(true);
				} else if (game.getLevelNum() == 1){
					game.getCurrentLevel().setLevelWon(false);
					frame.remove(game.getCurrentLevel());
					frame.setVisible(false);
					gameWonFrame.setVisible(true);
					restartWindowOpen = true;
				} else {
					System.out.println("oops");
				}
				
			} else if (!restartWindowOpen){
				frame.setVisible(true);
				//System.out.println("test");
			}
		}
		frame.setVisible(false);

		
		
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