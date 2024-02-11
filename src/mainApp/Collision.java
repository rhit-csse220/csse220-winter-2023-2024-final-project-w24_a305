package mainApp;

import java.awt.Rectangle;

public interface Collision {
	
	public void collideCoin(Rectangle r);
	public void collideMissile(Rectangle r);
	public void collideBarrier(Rectangle r);
	public boolean collideWith(Rectangle r);
}
