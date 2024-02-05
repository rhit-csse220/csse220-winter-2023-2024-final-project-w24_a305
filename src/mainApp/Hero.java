package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;


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
	
	
	public Hero() {
		this.x = startingX;
		this.y = startingY;
		this.gravity = 0;
		
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
	}
	/**
	 * Resets the Hero's x & y values to their starting values.
	 */
	public void restartPos() {
		this.x = startingX;
		this.y = startingY;
	}
	
	public double getGravity() {
		return this.gravity;
	}
	
	public void setGravity(double value) {
		this.gravity += value;
	}
	
}
