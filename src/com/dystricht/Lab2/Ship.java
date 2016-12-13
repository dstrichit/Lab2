package com.dystricht.Lab2;

import edu.princeton.cs.introcs.StdDraw;

public class Ship extends Body {
	
	double[] xPoly = {0, 2, 0, -2}, yPoly = {0, -2, 4, -2};
	double[] xcoords = {0, 0, 0, 0}, ycoords = {0, 0, 0, 0};
	double rotate = 0;


	public Ship(double iMass, double startX, double startY) {
		super(iMass, startX, startY, 0, 0, 0, 0, 0, 0);
	}
	
	public void draw(double cx, double cy){
		
		
		for(int i = 0; i<xPoly.length; i++){
			//xcoords[i] = 0; ycoords[i] = 0;
			xcoords[i] = this.x + xPoly[i];
			ycoords[i] = this.y + yPoly[i];
		}
		
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledPolygon(xcoords, ycoords);
		
		for(int i = 0; i < xPoly.length-1; i++){
			xcoords[i] = 0;
			ycoords[i] = 0;
		}
	}
	
	

}
