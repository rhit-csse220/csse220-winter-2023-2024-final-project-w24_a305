package mainApp;

import java.awt.Color;

public class DiagonalMissile extends Missile {

public static final String title = "DiagonalMissile";
private boolean upDown;
	
	public DiagonalMissile(int xCoord, int yCoord) {
		super(xCoord, yCoord, Color.PINK);
		this.upDown = true;
		
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
		return "DiagonalMissile";
	}
	
	@Override
	public void handleCollision(Hero r) {
		// TODO Auto-generated method stub
		r.setHealth(-1);
	}


	@Override
	public void updateSelf(Hero barrySteakfries) {
		// TODO Auto-generated method stub

		this.setX(12);
		if (this.getY() < 20) {
			this.upDown = false;
		} else if (this.getY() > 350) {
			this.upDown = true;
		}
		
		if (upDown) {
			this.setY(-7);
		} else {
			this.setY(7);
		}
		
	}

	
	
	
	
	
}


