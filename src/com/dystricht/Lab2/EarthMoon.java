package com.dystricht.Lab2;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class EarthMoon {

	public static final double WIDTH = 600, HEIGHT = 600, CENX = WIDTH/2, CENY = HEIGHT/2;
	public static boolean running = true,
			clear = true;
	
	public static final double pixelsPerMeter = (double)3/1e7;
	
	public static void main(String[] args) {
		
		StdDraw.setXscale(0, WIDTH);
		StdDraw.setYscale(0, HEIGHT);
		
		StdDraw.clear(StdDraw.BLACK);
		
		double earthMass = 5.9736e24; double moonMass = 7.3477e22; double marsMass = 6.3548e23;
		double earthx = 0.0, earthy = 0.0, moonx = 3.844e8;
		int earthpix = 30; int moonpix = 6; int marspix = 18;
		double earthDown = -12.5709, moonUp = 1022;
		Color marsColor = new Color(233, 37, 37);
		
		Body earth = new Body(earthMass, earthx, earthy, 0, earthDown, earthpix, 0, 30, 255 );
		Body moon  = new Body(moonMass, moonx, 0, 100, moonUp, moonpix, 128, 128, 128);
		earth.toggleStaticPlanet();
		
		Body mars = new Body(marsMass, -moonx, 0, -200, -moonUp, marspix, marsColor.getRed(), marsColor.getGreen(), marsColor.getBlue());
		//Body earth2 = new
		ArrayList<Body> earthmoon = new ArrayList<Body>();
		earthmoon.add(earth); earthmoon.add(moon);
		earthmoon.add(mars);
		
		earthmoon.get(0).setName("earth"); earthmoon.get(1).setName("moon");
		earthmoon.get(2).setName("mars");
		
		GravitationalSystem lunarSys = new GravitationalSystem(earthmoon);
		
		double timestep = (double)1000000/30;
		
		while(running){
			
			if(StdDraw.isKeyPressed(KeyEvent.VK_Q)){;
				running = !running;
				continue;
			}
			StdDraw.enableDoubleBuffering();
			if (clear == true) StdDraw.clear(StdDraw.BLACK);
			for(Body b : lunarSys.bodies){
				b.setAccelZero();
			}
			lunarSys.update(timestep);
			lunarSys.draw(CENX, CENY, pixelsPerMeter);
			

			if(CENX + lunarSys.bodies.get(1).scaleXandY(pixelsPerMeter)[0] < CENX - 100){
				//System.out.println("left side of screen");
			}
		
			StdDraw.show();
			StdDraw.pause(30);		
			//running = false;
		}
		
		System.exit(1);
		
		
	}
}
