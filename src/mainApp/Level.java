package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;

/**
 * Class: Level. Extends JComponent
 * 
 * <br>
 * Pupose: Create the level and instantiate all the barriers, coins, missiles,
 * and player character.
 */
public class Level extends JComponent {

	private ArrayList<Collision> gameObjects;
	private Hero barrySteakfries;
	private boolean spacePressed;
	private boolean gameOver;
	private Rectangle safeZone;
	private boolean levelWon;

	public Level(String filename) throws FileNotFoundException, IOException, InvalidLevelFormat {

		this.gameObjects = new ArrayList<Collision>();
		this.levelWon = false;
		this.barrySteakfries = new Hero();
		this.spacePressed = false;
		safeZone = new Rectangle(940, 0, 60, 400);
		fileScanner(filename);
		gameOver = false;

	}

	/**
	 * Takes in the current file name and reads each line to create the barriers,
	 * coins, and missiles. Checks if file is correctly formatted. If not, throws an
	 * InvalidLevelFormat Exception. If the file is not found, throws a
	 * FileNotFoundException.
	 * 
	 * @param filename
	 * @throws InvalidLevelFormat
	 * @throws IOException
	 */
	public void fileScanner(String filename) throws InvalidLevelFormat, IOException {
		try {
			FileReader f = new FileReader(filename);
			Scanner s = new Scanner(f);

			String[] currentLine = s.nextLine().split(",");
			for (int i = 0; i < 2; i++) {

				if (currentLine.length % 3 != 0) {
					throw new InvalidLevelFormat();
				}
				currentLine = s.nextLine().split(",");
			}
			if (currentLine.length % 2 != 0) {
				throw new InvalidLevelFormat();
			}

			FileReader f2 = new FileReader(filename);
			Scanner s2 = new Scanner(f2);

			createNormalBarriers(s2.nextLine());
			createElectricBarriers(s2.nextLine());
			createCoins(s2.nextLine());
			createNormalMissiles(s2.nextLine());
			createTrackingMissiles(s2.nextLine());
			createCoolCoins(s2.nextLine());
			createHeartPowerup(s2.nextLine());
			createDiagonalMissile(s2.nextLine());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}


	}
	
	

	/**
	 * Creates the Normal Barriers by taking in a string with x & y coordinates and
	 * a rotation angle. The coordinates are for the top-right point of the
	 * rectangle. Calculates the other 3 points using trig with the given rotation
	 * angle and draws a Polygon using a java list of the x and y coordinates of
	 * each point.
	 * 
	 * @param normalBarrierParam
	 */

	public void createNormalBarriers(String normalBarrierParam) {


		String[] coordinates = normalBarrierParam.split(",");

		int sideLength = 50;

		String x = "";
		String y = "";
		String rotation = "";
		int numOfBarriers = coordinates.length / 3;

		for (int j = 0; j < numOfBarriers; j++) {

			String[] sub = new String[3];
			sub[0] = coordinates[j * 3];
			sub[1] = coordinates[j * 3 + 1];
			sub[2] = coordinates[j * 3 + 2];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				} else {
					rotation = sub[i];
				}
			}
			int[] xCoords = new int[4];
			xCoords[0] = Integer.parseInt(x);
			xCoords[1] = (int) (Integer.parseInt(x)
					+ sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[2] = (int) (xCoords[1] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[3] = (int) (xCoords[0] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			int[] yCoords = new int[4];
			yCoords[0] = Integer.parseInt(y);
			yCoords[1] = (int) (Integer.parseInt(y)
					+ sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[2] = (int) (yCoords[1] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[3] = (int) (yCoords[0] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			
			
			Collision normalBarrier = new NormalBarrier(xCoords, yCoords);
			this.gameObjects.add(normalBarrier);

		}
	}

	/**
	 * Creates the Electric Barriers by taking in a string with x & y coordinates
	 * and a rotation angle. The coordinates are for the top-right point of the
	 * rectangle. Calculates the other 3 points using trig with the given rotation
	 * angle and draws a Polygon using a java list of the x and y coordinates of
	 * each point.
	 * 
	 * @param electricBarrierParam
	 */
	public void createElectricBarriers(String electricBarrierParam) {
		String[] coordinates = electricBarrierParam.split(",");

		int sideLength = 50;

		String x = "";
		String y = "";
		String rotation = "";
		int numOfBarriers = coordinates.length / 3;

		for (int j = 0; j < numOfBarriers; j++) {

			String[] sub = new String[3];
			sub[0] = coordinates[j * 3];
			sub[1] = coordinates[j * 3 + 1];
			sub[2] = coordinates[j * 3 + 2];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				} else {
					rotation = sub[i];
				}
			}
			int[] xCoords = new int[4];
			xCoords[0] = Integer.parseInt(x);
			xCoords[1] = (int) (Integer.parseInt(x)
					+ sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[2] = (int) (xCoords[1] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[3] = (int) (xCoords[0] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			int[] yCoords = new int[4];
			yCoords[0] = Integer.parseInt(y);
			yCoords[1] = (int) (Integer.parseInt(y)
					+ sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[2] = (int) (yCoords[1] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[3] = (int) (yCoords[0] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			
			Collision electricBarrier = new ElectricBarrier(xCoords, yCoords);
			this.gameObjects.add(electricBarrier);
		}
	}

	/**
	 * Creates coins from a String that contains a list of x & y coordinates.
	 * 
	 * @param coinParam
	 */
	public void createCoins(String coinParam) {

		String[] coordinates = coinParam.split(",");

		String x = "";
		String y = "";
		int numOfCoins = coordinates.length / 2;

		for (int j = 0; j < numOfCoins; j++) {

			String[] sub = new String[2];
			sub[0] = coordinates[j * 2];
			sub[1] = coordinates[j * 2 + 1];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				}
			}

			int xCoord = Integer.parseInt(x);
			int yCoord = Integer.parseInt(y);

			Collision coin = new Coin(xCoord, yCoord);
			this.gameObjects.add(coin);
		}

	}
	
	/**
	 * Creates a second kind of coin, that is worth 3 points instead of 1.
	 * X/Y coordinates for its location are taken from the current level text file.
	 * @param coinParam
	 */
	public void createCoolCoins(String coinParam) {
		String[] coordinates = coinParam.split(",");

		String x = "";
		String y = "";
		int numOfCoins = coordinates.length / 2;

		for (int j = 0; j < numOfCoins; j++) {

			String[] sub = new String[2];
			sub[0] = coordinates[j * 2];
			sub[1] = coordinates[j * 2 + 1];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				}
			}

			int xCoord = Integer.parseInt(x);
			int yCoord = Integer.parseInt(y);

			Collision coolCoin = new CoolCoin(xCoord, yCoord);
			this.gameObjects.add(coolCoin);
		}
	}

	/**
	 * Creates normal missiles from a String that contains a list of x & y
	 * coordinates.
	 * 
	 * @param normalMissilesParam
	 */
	public void createNormalMissiles(String normalMissilesParam) {

		String[] coordinates = normalMissilesParam.split(",");

		String x = "";
		String y = "";
		int numOfMissiles = coordinates.length / 2;

		for (int j = 0; j < numOfMissiles; j++) {

			String[] sub = new String[2];
			sub[0] = coordinates[j * 2];
			sub[1] = coordinates[j * 2 + 1];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				}
			}

			int xCoord = Integer.parseInt(x);
			int yCoord = Integer.parseInt(y);
			
			Collision missile = new NormalMissile(xCoord, yCoord);
			this.gameObjects.add(missile);
		}
		

	}

	/**
	 * Creates tracking missiles from a String that contains a list of x & y
	 * coordinates.
	 * 
	 * @param trackingMissilesParam
	 */
	public void createTrackingMissiles(String trackingMissilesParam) {

		String[] coordinates = trackingMissilesParam.split(",");

		String x = "";
		String y = "";
		int numOfMissiles = coordinates.length / 2;

		for (int j = 0; j < numOfMissiles; j++) {

			String[] sub = new String[2];
			sub[0] = coordinates[j * 2];
			sub[1] = coordinates[j * 2 + 1];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				}
			}

			int xCoord = Integer.parseInt(x);
			int yCoord = Integer.parseInt(y);
			
			Collision missile = new TrackingMissile(xCoord, yCoord);
			this.gameObjects.add(missile);
		}

	}
	
	/**
	 * Creates a heart powerup that increases the number of hearts by 1. Takes in x/y coordinates
	 * from a scanner that reads the current level's text file.
	 * @param heartPowerupParam
	 */
	public void createHeartPowerup(String heartPowerupParam) {
		
		String[] coordinates = heartPowerupParam.split(",");

		String x = "";
		String y = "";
		int numOfPowerups = coordinates.length / 2;

		for (int j = 0; j < numOfPowerups; j++) {

			String[] sub = new String[2];
			sub[0] = coordinates[j * 2];
			sub[1] = coordinates[j * 2 + 1];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				}
			}

			int xCoord = Integer.parseInt(x);
			int yCoord = Integer.parseInt(y);

			Collision heartPowerup = new HeartPowerup(xCoord, yCoord);
			this.gameObjects.add(heartPowerup);
		}
	}
	
	/**
	 * Creates diagonal missiles that move diagonal up/down across a certain range. Takes in starting x/y coordinates
	 * from a scanner that reads the current level's text file.
	 * @param diagonalParam
	 */
	public void createDiagonalMissile(String diagonalParam) {
		String[] coordinates = diagonalParam.split(",");

		String x = "";
		String y = "";
		int numOfMissiles = coordinates.length / 2;

		for (int j = 0; j < numOfMissiles; j++) {

			String[] sub = new String[2];
			sub[0] = coordinates[j * 2];
			sub[1] = coordinates[j * 2 + 1];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				}
			}

			int xCoord = Integer.parseInt(x);
			int yCoord = Integer.parseInt(y);
			
			Collision diagonalMissile = new DiagonalMissile(xCoord, yCoord);
			this.gameObjects.add(diagonalMissile);
		}
	}

	/**
	 * Changes Barry's x & y values depending on the current state of the game or
	 * key pressed. Also alters the locations of the missiles
	 */
	public void updateState() {

		if (this.barrySteakfries.getX() < 960) {
			this.barrySteakfries.setX(7);
		}
		if (this.barrySteakfries.getY() < 340 && !this.spacePressed) {
			this.barrySteakfries.setGravity(1);
			this.barrySteakfries.setY(-7 + this.barrySteakfries.getGravity());

		}
		if (this.barrySteakfries.getY() > 0 && this.spacePressed) {
			this.barrySteakfries.setGravity(-1 * this.barrySteakfries.getGravity());
			this.barrySteakfries.setY(-7);

		}
		if (this.barrySteakfries.getY() == 0) {
			this.barrySteakfries.setY(0);
		}
		if (this.barrySteakfries.getY() < 0) {
			this.barrySteakfries.setY(-this.barrySteakfries.getY());
		}
		
		for (Collision gameObject: gameObjects) {
			
			if (gameObject.getType().equals("TrackingMissile") || gameObject.getType().equals("NormalMissile") ||
					gameObject.getType().equals("DiagonalMissile")) {
				if (gameObject.getX() < -50) {
					gameObject.restartPos(); 
				}
				
				gameObject.updateSelf(this.barrySteakfries);
			}
			
			if (gameObject.collideWith(this.barrySteakfries)) {
				gameObject.handleCollision(this.barrySteakfries);
				if (this.barrySteakfries.getHealth() == 0) {
					this.gameOver = true;
					System.out.println("Game Over!!!");
				} else if(gameObject.getType().equals("ElectricBarrier") || gameObject.getType().equals("NormalMissile") || 
						gameObject.getType().equals("TrackingMissile") || gameObject.getType().equals("DiagonalMissile") 
						&& this.barrySteakfries.getHealth() > 0) {
					gameObject.restartPos();
					System.out.println("You have " + this.barrySteakfries.getHealth() + " hearts left.");
					restart();
				}
			}
			
		}
		
		checkLevelWon();
		
		

	}

	/**
	 * Takes in a boolean value to check if the space bar has been pressed.
	 * 
	 * @param newValue
	 */
	public void setSpacePressed(boolean newValue) {
		this.spacePressed = newValue;
	}

	/**
	 * Restarts Barry's position on the screen. This is done when switching between
	 * levels.
	 */
	public void restart() {

		this.barrySteakfries.restartPos();
		for (Collision gameObject : gameObjects) {
			gameObject.restartPos();
		}

	}
	
	/**
	 * Handles returning the health of the hero
	 * @return the hero's current health
	 */
	
	public int handleReturnHealth() {
		return this.barrySteakfries.getHealth();
	}
	
	/**
	 * Handles returning the hero's coin amount
	 * @return the hero's current coin amount
	 */
	
	public int handleReturnCoins() {
		return this.barrySteakfries.getCoins();
	}
	
	/**
	 * Handles setting the hero's health to a certain number
	 * @param num
	 */
	
	public void handleHardSetHeroHealth(int num) {
		this.barrySteakfries.hardSetHealth(num);
	}
	
	/**
	 * handles setting the hero's coins to a certain number
	 * @param num
	 */
	
	public void handleHardSetHeroCoins(int num) {
		this.barrySteakfries.hardSetCoins(num);
	}

	/**
	 * Draws everything
	 * 
	 * @param g
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.GREEN);
		g2.fill(safeZone);
		
		for (Collision gameObject: gameObjects) {
			gameObject.drawOn(g2);
		}
		this.barrySteakfries.drawOn(g2);

	}
	
	/**
	 * Checks if the hero has won the current level by seeing if its x has passed a certain point.
	 * Depending on the answer, sets the levelWon variable to true/false
	 */
	public void checkLevelWon() {
		if (this.barrySteakfries.getX() > 940) {
			this.levelWon = true;
		} else {
			this.levelWon = false;
		}
		
		
	}
	
	/**
	 * Sets the levelWon variable the parameter's value
	 * @param set
	 */
	public void setLevelWon(boolean set) {
		this.levelWon = set;
	}
	
	/**
	 * Return the current level of the levelWon variable
	 * @return this.levelWon
	 */
	
	public boolean getLevelWon() {
		return this.levelWon;
	}
	
	/**
	 *  Returns the value of Game Over
	 * @return this.gameOver
	 */
	public boolean getGameOver(){
		return this.gameOver;
	}
	
	/**
	 * Resets the hero's health to 3 and coin amount to 0
	 */
	
	public void restartHeroStats() {
		this.barrySteakfries.hardSetCoins(0);
		this.barrySteakfries.hardSetHealth(3);
	}

}
