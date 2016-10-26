package com.dystricht.Lab2;

public class Moon extends Body {

	static double moonMass = 7.3477e22;
	static int moonPix = 6;
	static int r = 128, g = 128, b = 128;
	private static double startX = 3.844e8;
	private static double startY = 0;
	private static double iVX = 0;
	private static double iVY = 1022;
	
	public Moon() {
		super(moonMass, startX, startY, iVX, iVY, moonPix, r, g, b);
		this.name = "moon";
	}

}
