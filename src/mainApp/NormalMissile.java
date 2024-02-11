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
	public boolean collideWith(Hero r) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
}
