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

	
}
