package mainApp;

import java.awt.Color;
/**
 * Class: NormalMissile
 * <br>Purpose: Creates a missile that can only move horizontally
 */
public class NormalMissile extends Missile {
	public static final String title = "Normal Missile";
	
	public NormalMissile(int xCoord, int yCoord) {
		super(xCoord, yCoord, Color.MAGENTA);
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
