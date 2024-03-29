package mainApp;

import java.awt.Color;
import java.awt.Rectangle;
/**
 * Class: ElectricBarrier
 * <br>Purpose: For now, this only changes the color of the barrier to red. Checks to see if Barry collides with itself
 */
public class ElectricBarrier extends Barrier {

	public ElectricBarrier(int[] xCoords, int[] yCoords) {
		super(xCoords, yCoords, Color.RED);
		// TODO Auto-generated constructor stub
	}


	@Override
	/**
	 * Checks to see if the hero and the electric barrier intersects.
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


	@Override
	public void handleCollision(Hero r) {
		// TODO Auto-generated method stub
		r.setHealth(-1);
	}


	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "ElectricBarrier";
	}


	@Override
	public void restartPos() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateSelf(Hero barrySteakfries) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
}
