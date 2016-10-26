package com.dystricht.Lab2;

import edu.princeton.cs.introcs.StdDraw;

public class OurSolarSystem {

	public static final double WIDTH = 400, HEIGHT = 400, CENX = WIDTH/2, CENY = HEIGHT/2;
	public static boolean running = true,
			clear = true;
	
	public static final double pixelsPerMeter = (double)3/1e7;
	
	public static void main(String[] args) {
		
		StdDraw.setXscale(0, WIDTH);
		StdDraw.setYscale(0, HEIGHT);
		
		StdDraw.clear(StdDraw.BLACK);
		
		
	}

}
