package com.dystricht.Lab2;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class EarthMoon {

	public static final double WIDTH = 400, HEIGHT = 400, CENX = WIDTH/2, CENY = HEIGHT/2;
	public static boolean running = true, first = true;
	
	public static final double pixelsPerMeter = (double)3/1e7;
	
	public static void main(String[] args) {
		
		StdDraw.setXscale(0, WIDTH);
		StdDraw.setYscale(0, HEIGHT);
		
		StdDraw.clear(StdDraw.BLACK);
		
		double earthMass = 5.9736e24; double moonMass = 7.3477e22;
		double earthx = 0.0, earthy = 0.0, moonx = 3.844e8;
		int earthpix = 30; int moonpix = 6;
		Body earth = new Body(earthMass, earthx, earthy, 0, 0, earthpix, 0, 30, 255 );
		Body moon  = new Body(moonMass, moonx, 0, 0, 1022, moonpix, 128, 128, 128);
		
		ArrayList<Body> earthmoon = new ArrayList<Body>();
		earthmoon.add(earth); earthmoon.add(moon);
		earthmoon.get(0).setName("earth"); earthmoon.get(1).setName("moon");
		GravitationalSystem lunarSys = new GravitationalSystem(earthmoon);
		
		double timestep = (double)1000000/30;
		
		double checkX, checkY, aX, aY;
						
		while(running){
			
			if(StdDraw.isKeyPressed(KeyEvent.VK_Q)){;
				running = !running;
				continue;
			}
			StdDraw.enableDoubleBuffering();
			//StdDraw.clear(StdDraw.BLACK);
			lunarSys.update(timestep);
			lunarSys.draw(CENX, CENY, pixelsPerMeter);
			
			if(CENX + lunarSys.bodies.get(1).scaleXandY(pixelsPerMeter)[0] < CENX - 100){
				//System.out.println("left side of screen");
			}
		
			StdDraw.show();
			StdDraw.pause(20);		
			//running = false;
		}
		
		System.exit(1);
		
		
	}
}
