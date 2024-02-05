package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
/**
 * Abstract Class: Barrier
 * <br>Purpose: Makes it easier to write code for Normal and Electric Barrier since they share so many things
 * in common. 
 */
public abstract class Barrier {

	private int[] xCoords;
	private int[] yCoords;
	private Color color;
	
	public Barrier (int[] xCoords, int[] yCoords, Color color) {
		this.xCoords = xCoords;
		this.yCoords = yCoords;
		this.color = color;
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
	
}
