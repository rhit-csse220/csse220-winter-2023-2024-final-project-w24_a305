package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;


/**
 * class: Hero
 * <br>Purpose: Create a hero on the screen that can move vertically and horizontally.
 */
public class Hero {

	public static final int startingX = 10;
	public static final int startingY = 200;
	public static final int rightSpeed = 2;
	public static final int upSpeed = 4;
	public static final Color color = Color.BLUE;
	private int x;
	private int y;
	private int gravity;
	private int health;
	private int coins;
	private Rectangle rect;
	
	public Hero() {
		this.x = startingX;
		this.y = startingY;
		this.gravity = 0;
		this.health = 3;
		this.coins = 0;
		this.rect = new Rectangle(this.x,this.y,10,20);
		
	}
	/**
	 *Ensures Hero is drawn on the screen when called in Level.
	 * @param g2
	 */
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(color);
		
		g2.fillRect(this.x, this.y, 10, 20);
		
	}
	/**
	 * Returns the Hero's current x-value.
	 * @return this.x
	 */
	public int getX() {
		return this.x;
	}
	/**
	 * Changes the Hero's x-value by the param's amount.
	 * @param x
	 */
	public void setX(int x) {
		this.x += x;
		this.rect.x += x;
	}
	
	
	/**
	 * Returns the Hero's current y-value
	 * @return this.y
	 */
	public int getY() {
		return this.y;
	}
	/**
	 * Changes the Hero's y-value by the param's amount.
	 * @param y
	 */
	public void setY(double y) {
		this.y += y;
		this.rect.y += y;
	}
	/**
	 * Resets the Hero's x & y values to their starting values.
	 */
	public void restartPos() {
		this.x = startingX;
		this.y = startingY;
		this.rect.x = startingX;
		this.rect.y = startingY;
		this.gravity = 0;
	}
	/**
	 * Returns the gravity value for the hero
	 * @return this.gravity
	 */
	public double getGravity() {
		return this.gravity;
	}
	/**
	 * Changes the gravity value by the set amount
	 * @param value
	 */
	public void setGravity(double value) {
		this.gravity += value;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health += health;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins += coins;
	}
	public Rectangle getRect() {
		return rect;
	}
	
	
}
