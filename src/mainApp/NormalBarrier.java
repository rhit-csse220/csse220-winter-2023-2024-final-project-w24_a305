package mainApp;

import java.awt.Color;
import java.awt.Rectangle;

/**
 * Class: NormalBarrier
 * <br>Purpose: For now, this only changes the color of the barrier to black. Checks to see if Barry collides with it
 */
public class NormalBarrier extends Barrier {

	public NormalBarrier(int[] xCoords, int[] yCoords) {
		super(xCoords, yCoords, Color.BLACK);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Checks to see if the hero and the barrier intersects.
	 * @param Hero r
	 * @return boolean
	 * 
	 */
	public boolean collideWith(Hero r) {
		if (this.poly.intersects(r.getRect())) {
			return true;
		}
		return false;
	}

	

	
	
}
