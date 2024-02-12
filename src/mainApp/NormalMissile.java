package mainApp;

import java.awt.Color;
import java.awt.Rectangle;
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
	/**
	 * Checks to see if the hero and the normal missile intersects.
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
