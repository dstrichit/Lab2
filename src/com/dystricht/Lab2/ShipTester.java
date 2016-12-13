package com.dystricht.Lab2;

import edu.princeton.cs.introcs.StdDraw;

public class ShipTester {

	public static double WIDTH = 400, HEIGHT = 400, CENX = WIDTH / 2, CENY = HEIGHT / 2;

	public static void main(String[] args) {

		StdDraw.setXscale(-CENX, CENX);
		StdDraw.setYscale(-CENY, CENY);
		
		StdDraw.clear(StdDraw.BLACK);
		Ship ship = new Ship(20, 8, 8);
		while(true){
			StdDraw.enableDoubleBuffering();
			StdDraw.clear(StdDraw.BLACK);
			ship.draw(CENX, CENY);
			StdDraw.show();
			StdDraw.pause(100);
			ship.x++;
		}
		
	}

}
