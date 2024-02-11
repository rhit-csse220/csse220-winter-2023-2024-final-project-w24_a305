package mainApp;

import java.awt.Color;

/**
 * Class: NormalBarrier
 * <br>Purpose: For now, this only changes the color of the barrier to black. Later, Barry will not be able to pass through this
 * object.
 */
public class NormalBarrier extends Barrier {

	public NormalBarrier(int[] xCoords, int[] yCoords) {
		super(xCoords, yCoords, Color.BLACK);
		// TODO Auto-generated constructor stub
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
