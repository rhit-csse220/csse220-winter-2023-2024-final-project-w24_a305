package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Rectangle2D;

public abstract class Missile {
	
	private int xCoord;
	private int yCoord;
	private Color color;
	private int startingX;
	
	public Missile (int xCoord, int yCoord, Color color) {
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
		this.startingX = xCoord;
	}
	
	/**
	 * Code that makes the missile be drawn when called in Level.
	 * @param g2
	 */
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(this.color);
		
		
		g2.fillRect(xCoord,yCoord,50,20);
		
	}
	
	public void setX(int value) {
		this.xCoord -= value; 
	}
	
	public int getX() {
		return this.xCoord;
	}
	
	public int getY() {
		return this.yCoord;
	}
	
	public void restartPos() {
		this.xCoord = this.startingX;
	}
	
}
