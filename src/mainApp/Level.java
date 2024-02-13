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

	private ArrayList<Barrier> normalBarrierList;
	private ArrayList<Barrier> electricBarrierList;
	private ArrayList<Coin> coinList;
	private ArrayList<Missile> normalMissileList;
	private ArrayList<Missile> trackingMissileList;
	private Hero barrySteakfries;
	private boolean spacePressed;
	private boolean gameOver;
	private Rectangle safeZone;
	private boolean levelWon;

	public Level(String filename) throws FileNotFoundException, IOException, InvalidLevelFormat {
		// This makes me mad >:(

		// String normalBarrier = s.nextLine();
		// String electricBarrier = s.nextLine();
		// String coins = s.nextLine();
		this.levelWon = false;
		this.normalBarrierList = new ArrayList<Barrier>();
		// System.out.println(this.normalBarrierList);
		this.electricBarrierList = new ArrayList<Barrier>();
		this.coinList = new ArrayList<Coin>();
		this.normalMissileList = new ArrayList<Missile>();
		this.trackingMissileList = new ArrayList<Missile>();
		this.barrySteakfries = new Hero();
		this.spacePressed = false;
		safeZone = new Rectangle(940, 0, 60, 400);
		fileScanner(filename);
		gameOver = false;

		// createNormalBarriers(normalBarrier);

		// s.close();
		// f1.close();

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
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}

		// System.out.println(filename);

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

		// ArrayList<Polygon> normalBarriers = new ArrayList<Polygon>();

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
			
			Barrier normalBarrier = new NormalBarrier(xCoords, yCoords);
			this.normalBarrierList.add(normalBarrier);

		}
		// System.out.println(x);
		// System.out.println(y);
		// System.out.println(rotation);

		// normalBarriers.add(normalBarrier);
		// return normalBarriers;
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
			Barrier electricBarrier = new ElectricBarrier(xCoords, yCoords);
			this.electricBarrierList.add(electricBarrier);
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

			Coin coin = new Coin(xCoord, yCoord);

			this.coinList.add(coin);
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

			Missile missile = new NormalMissile(xCoord, yCoord);
			this.normalMissileList.add(missile);
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

			Missile missile = new TrackingMissile(xCoord, yCoord);

			this.trackingMissileList.add(missile);
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
		for (Coin coin : this.coinList) {
			if (coin.collideWith(this.barrySteakfries)) {
				this.barrySteakfries.setCoins(1);
				System.out.println("You have " + this.barrySteakfries.getCoins() + " coins.");
				coin.setCollected(true);
				coin.moveRectLoc(1500);
			}
		}
		
		for (Barrier barrier : this.normalBarrierList) {
			if(barrier.collideWith(this.barrySteakfries)) {
				if(this.barrySteakfries.getX() < barrier.getXFromLeft()) {
					this.barrySteakfries.setX(-7);
				}
				else if(this.barrySteakfries.getY() < barrier.getTopY()) {
					this.barrySteakfries.setY(7 - this.barrySteakfries.getGravity());
					this.barrySteakfries.setGravity(7 -this.barrySteakfries.getGravity());
					
				}
				else {
					System.out.println("d");
					this.barrySteakfries.setY(7);
				}
			}
		}
		
		for (Barrier barrier: this.electricBarrierList) {
			if (barrier.collideWith(this.barrySteakfries)) {
				this.barrySteakfries.setHealth(-1);
				
				if (this.barrySteakfries.getHealth() == 0) {
					System.out.println("You have " + this.barrySteakfries.getHealth() + " hearts left.");
					this.gameOver = true;
					System.out.println("Game Over!!!");
				} else if(this.barrySteakfries.getHealth() > 0) {
					System.out.println("You have " + this.barrySteakfries.getHealth() + " hearts left.");
					restart();
				}
			}
		}
		
		for (Missile missile : this.normalMissileList) {
			missile.setX(14);
			if (missile.collideWith(this.barrySteakfries)) {
				this.barrySteakfries.setHealth(-1);
				
				if (this.barrySteakfries.getHealth() == 0) {
					System.out.println("You have " + this.barrySteakfries.getHealth() + " hearts left.");
					this.gameOver = true;
					System.out.println("Game Over!!!");
				} else {
					System.out.println("You have " + this.barrySteakfries.getHealth() + " hearts left.");
					restart();
				}
			}
			if (missile.getX() < -50) {
				missile.restartPos();
			}

		}

		for (Missile missile : this.trackingMissileList) {
			missile.setX(14);
			if (missile.getX() > this.barrySteakfries.getX()) {
				if (missile.getY() < this.barrySteakfries.getY()) {
					missile.setY(3);
				} else if (missile.getY() > this.barrySteakfries.getY()) {
					missile.setY(-3);
				}
			}
			if (missile.collideWith(this.barrySteakfries)) {
				this.barrySteakfries.setHealth(-1);
				if (this.barrySteakfries.getHealth() == 0) {
					System.out.println("You have " + this.barrySteakfries.getHealth() + " hearts left.");
					this.gameOver = true;
					System.out.println("Game Over!!!");
				} else {
					System.out.println("You have " + this.barrySteakfries.getHealth() + " hearts left.");
					restart();
				}
			}
			if (missile.getX() < -50) {
				missile.restartPos();
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
		for (Missile missile : this.normalMissileList) {
			missile.restartPos();
		}
		for (Missile missile : this.trackingMissileList) {
			missile.restartPos();
		}
		for (Coin coin : this.coinList) {
			coin.setCollected(false);
			coin.moveRectLoc(coin.getX());
		}

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
		
		for (Barrier currentBarrier : this.normalBarrierList) {
			currentBarrier.drawOn(g2);
		}
		for (Barrier currentBarrier : this.electricBarrierList) {
			currentBarrier.drawOn(g2);
		}
		for (Coin currentCoin : this.coinList) {
			if (!currentCoin.isCollected()) {
				currentCoin.drawOn(g2);
			}
		}
		this.barrySteakfries.drawOn(g2);

		for (Missile missile : this.normalMissileList) {
			missile.drawOn(g2);
		}

		for (Missile missile : this.trackingMissileList) {
			missile.drawOn(g2);
		}

	}
	
	public void checkLevelWon() {
		
		if (this.barrySteakfries.getX() > 940) {
			this.levelWon = true;
			System.out.println("fortnite");
		} else {
			this.levelWon = false;
		}
		
		
	}
	
	public boolean getLevelWon() {
		System.out.println(this.levelWon);
		return this.levelWon;
	}
	
	/**
	 *  Returns the value of Game Over
	 * @return this.gameOver
	 */
	public boolean getGameOver(){
		return this.gameOver;
	}
	
	public void restartHeroStats() {
		this.barrySteakfries.setCoins(-this.barrySteakfries.getCoins());
		this.barrySteakfries.setHealth(3 - this.barrySteakfries.getHealth());
	}

}
