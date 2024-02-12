package mainApp;

import java.awt.Rectangle;

/**
 * Interface: Collission
 * <br> Classes implement this to be able to check if they intersect with hero.
 */
public interface Collision {

	public boolean collideWith(Hero r);
}
