package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class: Coin
 * <br>Purpose: Get the coin to show up on the screen. Later, coins will have different values.
 */
public class Coin implements Collision{

	public static final Color color = Color.ORANGE;
	public static final int diameter = 20;
	public static final String title = "Coin";
	private int x;
	private int y;
	private Rectangle rect;
	
	public Coin(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.rect = new Rectangle(this.x,this.y,diameter,diameter);
	}
	
	/**
	 * Ensures the coin is drawn when called in Level
	 * @param g2
	 */
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(color);
		g2.fillOval(this.x, this.y, diameter, diameter);
		
	}

	@Override
	public void collideCoin(Hero h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideMissile(Hero h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collideBarrier(Hero h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean collideWith(Rectangle r) {
		if (this.rect.intersects(r)) {
			return true;
		}
	}
	
}
