package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CoolCoin extends Collision{

	public static final Color color = Color.CYAN;
	public static final int diameter = 20;
	public static final String title = "Coin";
	private int x;
	private int y;
	private Rectangle rect;
	private boolean collected;
	private int value;
	
	public CoolCoin(int x, int y) {
		
		this.x = x;
		this.value = 3;
		this.y = y;
		this.rect = new Rectangle(this.x,this.y,diameter,diameter);
		collected = false;
	}
	
	/**
	 * Ensures the coin is drawn when called in Level
	 * @param g2
	 */
	@Override
	public void drawOn(Graphics2D g2) {
		
		if (!this.isCollected()) {
			g2.setColor(color);
			g2.fillOval(this.x, this.y, diameter, diameter);
		}
		
		
	}


	@Override
	/**
	 * Checks to see if the hero and the coin intersects.
	 * @param Hero r
	 * @return boolean
	 * 
	 */
	public boolean collideWith(Hero r) {
		if (this.rect.intersects(r.getRect())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Resets the collected variable to false and resets the coin's hitbox to its original location
	 */
	public void restartPos() {
		this.setCollected(false);
		this.moveRectLoc(this.getX());
	}

	/**
	 * Returns true if the coin was collected already
	 * @return boolean collected
	 */
	public boolean isCollected() {
		return collected;
	}

	/**
	 * changes the values of collected to value of the parameter
	 * @param collected
	 */
	public void setCollected(boolean collected) {
		this.collected = collected;
	}
	
	/**
	 * updates the x position of the rectangle for coin.
	 * @param x
	 */
	public void moveRectLoc(int x) {
		this.rect.x = x;
	}
	
	/**
	 * Returns the x value of the coin.
	 * @return this.x
	 */
	public int getX() {
		return this.x;
	}
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Coin";
	}
	
	@Override
	public void handleCollision(Hero r) {
		// TODO Auto-generated method stub
		r.setCoins(this.value);
		this.setCollected(true);
		this.moveRectLoc(1500);
	}

	@Override
	public void updateSelf(Hero barrySteakfries) {
		// TODO Auto-generated method stub
		
	}
	
	
}
