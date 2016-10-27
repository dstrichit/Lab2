package com.dystricht.Lab2;

public class Moon extends Body {

	public static double moonMass = 7.3477e22;
	private static int moonPix = 6;
	private static int r = 128, g = 128, b = 128;
	private static double startX = 3.844e8;
	private static double startY = 0;
	private static double iVX = 0;
	private static double iVY = 1022;
	
	public Moon(double startX, double startY, double iVX, double iVY) {
		super(moonMass, startX, startY, iVX, iVY, moonPix, r, g, b);
	}
	
	public Moon(){
		super(moonMass, startX, startY, iVX, iVY, moonPix, r, g, b);
	}

}
