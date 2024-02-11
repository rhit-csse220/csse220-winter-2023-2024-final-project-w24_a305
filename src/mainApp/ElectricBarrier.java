package mainApp;

import java.awt.Color;
import java.awt.Rectangle;
/**
 * Class: ElectricBarrier
 * <br>Purpose: For now, this only changes the color of the barrier to red. Later, if Barry touches this object,
 * he will lose a life.
 */
public class ElectricBarrier extends Barrier {

	public ElectricBarrier(int[] xCoords, int[] yCoords) {
		super(xCoords, yCoords, Color.RED);
		// TODO Auto-generated constructor stub
	}


	@Override
	public boolean collideWith(Hero r) {
		if (this.poly.intersects(r.getRect())) {
			return true;
		}
		return false;
	}

	
	
}
