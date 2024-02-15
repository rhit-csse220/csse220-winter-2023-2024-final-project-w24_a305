package mainApp;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Scanner;

/**
 * Interface: Collission
 * <br> Classes implement this to be able to check if they intersect with hero.
 */
public abstract class Collision {
	
	/**
	 * Checks if the object has intersected with the hero
	 * @param r
	 * @return true/false
	 */
	public abstract boolean collideWith(Hero r);
	
	/**
	 * Handles what happens when the object has collided with the hero
	 * @param r
	 */
	
	public abstract void handleCollision(Hero r);
	
	/**
	 * Returns a String that describes what the current object is
	 * @return
	 */
	
	public abstract String getType();
	
	/**
	 * Draws the object on the screen
	 * @param g2
	 */
	
	public abstract void drawOn(Graphics2D g2);
	
	/**
	 * Restarts the position of the object to their original values
	 */
	
	public abstract void restartPos();
	
	/**
	 * Updates the position of the object's x/y depending on the hero's location, if they need to.
	 * @param barrySteakfries
	 */
	public abstract void updateSelf(Hero barrySteakfries);
	
	/**
	 * Returns the object's x value
	 * @return x
	 */
	public abstract int getX();
	
	
}
