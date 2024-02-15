package mainApp;

import java.awt.Color;
import java.awt.Rectangle;
/**
 * Class: TrackingMissile
 * <br>Purpose: Creates a missile that moves horizontally, as well as vertically to track the hero.
 */
public class TrackingMissile extends Missile {
	
	public TrackingMissile(int xCoord, int yCoord) {
		super(xCoord, yCoord, Color.DARK_GRAY);
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
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "TrackingMissile";
	}
	
	@Override
	public void handleCollision(Hero r) {
		// TODO Auto-generated method stub
		r.setHealth(-1);
	}
	
	
	/**
	 * Updates the position of the tracking missile's x by a set amount and the y by an amount dependent on the location
	 * of the hero on the screen
	 * @param r
	 */
	public void updateSelf(Hero r) {
		this.setX(14);
		if (this.getX() > r.getX()) {
			if (this.getY() < r.getY()) {
				this.setY(3);
			} else if (this.getY() > r.getY()) {
				this.setY(-3);
			}
		}
	}

	
}
