package mainApp;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class: NormalMissile
 * <br>Purpose: Creates a missile that can only move horizontally
 */
public class NormalMissile extends Missile {
	public static final String title = "NormalMissile";
	
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
	
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "NormalMissile";
	}
	
	@Override
	public void handleCollision(Hero r) {
		// TODO Auto-generated method stub
		r.setHealth(-1);
	}


	@Override
	public void updateSelf(Hero barrySteakfries) {
		// TODO Auto-generated method stub

		this.setX(14);
	}

	
	
	
	
	
}
