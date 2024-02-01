package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;

public class Coin {

	public static final Color color = Color.ORANGE;
	public static final int diameter = 20;
	
	private int x;
	private int y;
	
	public Coin(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	
	public void drawOn(Graphics2D g2) {
		
		g2.setColor(color);
		
		g2.fillOval(this.x, this.y, diameter, diameter);
		
	}
	
}
