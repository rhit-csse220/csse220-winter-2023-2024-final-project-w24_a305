package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
/**
 * Class: Missile
 * <br>Purpose: Gets a number of missiles to show up on screen. 
 */
public abstract class Missile implements Collision {
	
	private int xCoord;
	private int yCoord;
	private Color color;
	private int startingY;
	private int startingX;
	protected Rectangle rect;
	
	public Missile (int xCoord, int yCoord, Color color) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
		this.startingX = xCoord;
		this.startingY = yCoord;
		this.rect = new Rectangle(xCoord,yCoord,50,20);
	}
	
	/**
	 * Code that makes the missile be drawn when called in Level.
	 * @param g2
	 */
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(this.color);
		
		
		g2.fillRect(xCoord,yCoord,50,20);
		
	}
	/**
	 * Changes the missile's x value by the given value.
	 * @param value
	 */
	public void setX(int value) {
		this.xCoord -= value;
		this.rect.x -= value;
	}
	/**
	 * Returns the x value for the missile.
	 * @return this.xCoord
	 */
	public int getX() {
		return this.xCoord;
	}
	/**
	 * Returns the y value for the missile.
	 * @return
	 */
	public int getY() {
		return this.yCoord;
	}
	/**
	 * Changes the missile's y value by the given value.
	 * @param value
	 */
	public void setY(int value) {
		this.yCoord += value;
		this.rect.y += value;
	}
	/**
	 * Sets the missile x position to its original value when changing a level.
	 */
	public void restartPos() {
		this.xCoord = this.startingX;
		this.yCoord = this.startingY;
		this.rect.x = this.startingX;
		this.rect.y = this.startingY;
	}
	
}
