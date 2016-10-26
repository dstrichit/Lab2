package com.dystricht.Lab2;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Body {
	
	double mass;
	double x, y;
	double vx, vy;
	int radius;
	private Color color;
	public String name = "";
	private double[] acceleration = new double[2];
	public boolean staticPlanet = false;
	
	public Body(double iMass, double startX, double startY, double iVX, double iVY, int pixelRadius, int r, int g, int b){
		
		mass = iMass;
		x = startX; y = startY;
		vx = iVX; vy = iVY;
		radius = pixelRadius;
		color = new Color(r, g, b);
		
	}
	
	public void updatePosition(double timestep){
		
		if(this.staticPlanet == true){
			x = 0;
			y = 0;
			return;
		}
		
		x += vx*timestep;
		y += vy*timestep;
		
	}
	public void updateVelocity(double timestep){
//		vx += ax * timestep;
//		vy += ay * timestep;
		vx += acceleration[0] * timestep;
		vy += acceleration[1] * timestep;
	}
	public void draw(double cx, double cy, double pixelsPerMeter){
		
		StdDraw.setPenColor(color);
		double scaledX = x * pixelsPerMeter; double scaledY = y * pixelsPerMeter;
		StdDraw.filledCircle(cx + scaledX, cy + scaledY, radius);
		
	}
	
	public String toString(){
		return this.name;
		
	}
	
	public void setName(String s){
		name = s;
	}
	
	public double[] scaleXandY(double pixelsPerMeter){
		
		double scaledPos[] = { x * pixelsPerMeter, y * pixelsPerMeter};
		return scaledPos;
	}
	
	public void setAccel(double[] newAccels){
		
		acceleration[0] = newAccels[0];
		acceleration[1] = newAccels[1];
	}
	public void setAccel(){
		acceleration[0] = 0;
		acceleration[1] = 0;
	}
	public void findStaticVel(){
		
	}
	
	public void toggleStaticPlanet(){
		staticPlanet = !staticPlanet;
	}
}
