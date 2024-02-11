package mainApp;

import java.awt.Color;
/**
 * Class: TrackingMissile
 * <br>Purpose: Creates a missile that moves horizontally, as well as vertically to track the hero.
 */
public class TrackingMissile extends Missile {
	
	public TrackingMissile(int xCoord, int yCoord) {
		super(xCoord, yCoord, Color.DARK_GRAY);
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
	public void collideWith(Hero h) {
		// TODO Auto-generated method stub
		
	}
}
