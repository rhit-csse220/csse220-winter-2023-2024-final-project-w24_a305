package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Hero {

	public static final int startingX = 10;
	public static final int startingY = 200;
	public static final int rightSpeed = 2;
	public static final int upSpeed = 4;
	public static final Color color = Color.BLUE;
	private int x;
	private int y;
	
	
	public Hero() {
		this.x = startingX;
		this.y = startingY;
		
	}
	
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(color);
		
		g2.fillRect(this.x, this.y, 10, 20);
		
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x += x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y += y;
	}
	
}
