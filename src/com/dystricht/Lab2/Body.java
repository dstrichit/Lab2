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
	
	public Body(double iMass, double startX, double startY, double iVX, double iVY, int pixelRadius, int r, int g, int b){
		
		mass = iMass;
		x = startX; y = startY;
		vx = iVX; vy = iVY;
		radius = pixelRadius;
		color = new Color(r, g, b);
		
	}
	
	public void updatePosition(double timestep){
		
		x += vx*timestep;
		y += vy*timestep;
		
	}
	public void updateVelocity(double ax, double ay, double timestep){
		vx += ax * timestep;
		vy += ay * timestep;
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
}
