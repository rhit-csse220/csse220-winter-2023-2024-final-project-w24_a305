package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComponent;

public class Level extends JComponent {

	private ArrayList<Barrier> normalBarrierList;
	private ArrayList<Barrier> electricBarrierList;
	private ArrayList<Coin> coinList;
	private Hero barrySteakfries;
	private boolean spacePressed;

	public Level(String filename) throws FileNotFoundException, IOException {
		// This makes me mad >:(

		// String normalBarrier = s.nextLine();
		// String electricBarrier = s.nextLine();
		// String coins = s.nextLine();
		
		

		this.normalBarrierList = new ArrayList<Barrier>();
		// System.out.println(this.normalBarrierList);
		this.electricBarrierList = new ArrayList<Barrier>();
		this.coinList = new ArrayList<Coin>();
		this.barrySteakfries = new Hero();
		this.spacePressed = false;
		fileScanner(filename);
		
		

		// createNormalBarriers(normalBarrier);

		// s.close();
		// f1.close();

	}

	public void fileScanner(String filename) throws FileNotFoundException {
		try {
			FileReader f1 = new FileReader(filename);
			Scanner s = new Scanner(f1);
			createNormalBarriers(s.nextLine());
			createElectricBarriers(s.nextLine());
			createCoins(s.nextLine());
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}

		// System.out.println(filename);

	}

	public void createNormalBarriers(String normalBarrierParam) {

		// ArrayList<Polygon> normalBarriers = new ArrayList<Polygon>();

		String[] coordinates = normalBarrierParam.split(",");

		int sideLength = 50;

		String x = "";
		String y = "";
		String rotation = "";
		int numOfBarriers = coordinates.length / 3;

		for (int j = 0; j < numOfBarriers; j++) {

			String[] sub = new String[3];
			sub[0] = coordinates[j * 3];
			sub[1] = coordinates[j * 3 + 1];
			sub[2] = coordinates[j * 3 + 2];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				} else {
					rotation = sub[i];
				}
			}
			int[] xCoords = new int[4];
			xCoords[0] = Integer.parseInt(x);
			xCoords[1] = (int) (Integer.parseInt(x)
					+ sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[2] = (int) (xCoords[1] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[3] = (int) (xCoords[0] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			int[] yCoords = new int[4];
			yCoords[0] = Integer.parseInt(y);
			yCoords[1] = (int) (Integer.parseInt(y)
					+ sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[2] = (int) (yCoords[1] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[3] = (int) (yCoords[0] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			Barrier normalBarrier = new NormalBarrier(xCoords, yCoords);
			this.normalBarrierList.add(normalBarrier);

		}
		// System.out.println(x);
		// System.out.println(y);
		// System.out.println(rotation);

		// normalBarriers.add(normalBarrier);
		// return normalBarriers;
	}

	public void createElectricBarriers(String electricBarrierParam) {
		String[] coordinates = electricBarrierParam.split(",");

		int sideLength = 50;

		String x = "";
		String y = "";
		String rotation = "";
		int numOfBarriers = coordinates.length / 3;

		for (int j = 0; j < numOfBarriers; j++) {

			String[] sub = new String[3];
			sub[0] = coordinates[j * 3];
			sub[1] = coordinates[j * 3 + 1];
			sub[2] = coordinates[j * 3 + 2];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				} else {
					rotation = sub[i];
				}
			}
			int[] xCoords = new int[4];
			xCoords[0] = Integer.parseInt(x);
			xCoords[1] = (int) (Integer.parseInt(x)
					+ sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[2] = (int) (xCoords[1] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			xCoords[3] = (int) (xCoords[0] - sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			int[] yCoords = new int[4];
			yCoords[0] = Integer.parseInt(y);
			yCoords[1] = (int) (Integer.parseInt(y)
					+ sideLength * Math.sin(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[2] = (int) (yCoords[1] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			yCoords[3] = (int) (yCoords[0] + sideLength * Math.cos(Integer.parseInt(rotation) * Math.PI / 180));
			Barrier electricBarrier = new ElectricBarrier(xCoords, yCoords);
			this.electricBarrierList.add(electricBarrier);
		}
	}
	
	public void createCoins(String coinParam) {
		
		String[] coordinates = coinParam.split(",");

		String x = "";
		String y = "";
		int numOfCoins = coordinates.length / 2;

		for (int j = 0; j < numOfCoins; j++) {

			String[] sub = new String[2];
			sub[0] = coordinates[j * 2];
			sub[1] = coordinates[j * 2 + 1];

			for (int i = 0; i < 3; i++) {

				if (i == 0) {
					x = sub[i];
				} else if (i == 1) {
					y = sub[i];
				}
			}
			
			int xCoord = Integer.parseInt(x);
			int yCoord = Integer.parseInt(y);
			
			Coin coin = new Coin(xCoord, yCoord);
			
			this.coinList.add(coin);
		}
		
	}
	
	public void updateState() {
		
		
		
		if (this.barrySteakfries.getX() < 960) {
			this.barrySteakfries.setX(10);
		}
		if (this.barrySteakfries.getY() > 0 && this.spacePressed) {
			this.barrySteakfries.setY(-4);
		}
		
	}
	
	public void setSpacePressed(boolean newValue) {
		this.spacePressed = newValue;
	}
	
	public void restartBarrySteakfries() {
		
		this.barrySteakfries.restartPos();
		
	}
	

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		for (Barrier currentBarrier : this.normalBarrierList) {
			currentBarrier.drawOn(g2);
		}
		for (Barrier currentBarrier : this.electricBarrierList) {
			currentBarrier.drawOn(g2);
		}
		for (Coin currentCoin : this.coinList) {
			currentCoin.drawOn(g2);
		}
		this.barrySteakfries.drawOn(g2);
		
		

	}

}
