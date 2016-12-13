package com.dystricht.Lab2;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Body {

	double mass;
	double x, y;
	double vx, vy;
	int radius;
	private Color color; //simplifying Color
	//human readable name of planet
	public String name = ""; //originally to identify with toString(). now also used to display names onscreen
	private double[] acceleration = new double[2];
	//static flag for planet, used to center a body onscreen
	public boolean isStatic = false;

	public Body(double iMass, double startX, double startY, double iVX, double iVY, int pixelRadius, int r, int g,
			int b) {
		
		mass = iMass;
		x = startX;
		y = startY;
		vx = iVX;
		vy = iVY;
		radius = pixelRadius;
		color = new Color(r, g, b);

	}

	//update position using velocity & timestep
	public void updatePosition(double timestep) {

		x += vx * timestep;
		y += vy * timestep;

	}

	//update velocity using accelerations & timestep
	public void updateVelocity(double timestep) {
		// vx += ax * timestep;
		// vy += ay * timestep;
		vx += acceleration[0] * timestep;
		vy += acceleration[1] * timestep;
	}

	//draw this instance  of Body. Should be called by a system
	public void draw(double cx, double cy, double pixelsPerMeter) {

		StdDraw.setPenColor(color);
		double scaledX = x * pixelsPerMeter;
		double scaledY = y * pixelsPerMeter;
		StdDraw.filledCircle(cx + scaledX, cy + scaledY, radius);

	}

	//useful for identifying Bodies in debug
	public String toString() {
		return this.name;

	}

	//set human readable name of planet
	public void setName(String s) {
		name = s;
	}

	//scale X and Y to give useful data for drawing objects
	public double[] scaleXandY(double pixelsPerMeter) {

		double scaledPos[] = { x * pixelsPerMeter, y * pixelsPerMeter };
		return scaledPos;
	}

	//add accelerations.
	//written the way it is due to previous structure of code
	public void addAccel(double[] newAccels) {
		this.acceleration[0] += newAccels[0];
		this.acceleration[1] += newAccels[1];
	}
	
	//set body acceleration to zero
	public void setAccelZero() {
		this.acceleration[0] = 0;
		this.acceleration[1] = 0;
	}

	//unused as of now.
	public void findStaticVel() {
	}

	//togle 'static' central body flag. for sun or other body with satellites
	public void toggleStaticPlanet() {
		this.isStatic = (!this.isStatic);
	}
	
	//set color of body 'from without'
	public void setColor(Color c){
		this.color = c;
	}
}
