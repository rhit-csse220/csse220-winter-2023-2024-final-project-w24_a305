package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class: Coin
 * <br>Purpose: Get the coin to show up on the screen. Later, coins will have different values.
 */
public class Coin {

	public static final Color color = Color.ORANGE;
	public static final int diameter = 20;
	
	private int x;
	private int y;
	
	public Coin(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	/**
	 * Ensures the coin is drawn when called in Level
	 * @param g2
	 */
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(color);
		
		g2.fillOval(this.x, this.y, diameter, diameter);
		
	}
	
}
