package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
/**
 * Abstract Class: Barrier
 * <br>Purpose: Makes it easier to write code for Normal and Electric Barrier since they share so many things
 * in common. 
 */
public abstract class Barrier implements Collision {

	private int[] xCoords;
	private int[] yCoords;
	private Color color;
	protected Polygon poly;
	
	public Barrier (int[] xCoords, int[] yCoords, Color color) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.color = color;
		this.poly = new Polygon(xCoords,yCoords,4);
		
	}
	
	/**
	 * Code that makes the barrier be drawn when called in Level.
	 * @param g2
	 */
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(this.color);
		
		Polygon barrier = new Polygon(xCoords,yCoords,4);
		
		g2.fill(barrier);
		
	}
	
	public int getXFromLeft() {
		return xCoords[0];
	}
	
	public int getBottomY() {
		return yCoords[2];
	}
	
	public int getTopY() {
		return yCoords[0];
	}
}
