package com.dystricht.Lab2;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class OurSolarSystem {
	//declaring main program constants
	public static double WIDTH = 3200, HEIGHT = 3200, CENX = WIDTH / 2, CENY = HEIGHT / 2; //resolution
	public static double scaleInc = 32; //increment for resizing resolution
	public static double centerscaleidk = 32; //An attempt at centering a body on the screen
	public static int frameRate = 5; //not technically frame rate. more a pause rate
	public static boolean running = true, clear = true; //flags for running and for clearing. (!clearing for debug & art)
	public static int statIndex = 0; //index of 'static' or central body. the sun
	public static double WINCENTER; //unused, may use in the future
	public static final double pixelsPerMeter = 3 / 1e7, timestep = 1e5 / 3; //drawing/timestep constants

	public static GravitationalSystem solar;

	public static void main(String[] args) {
		StdDraw.setCanvasSize(800, 800);

		StdDraw.setXscale(CENX, WIDTH);
		StdDraw.setYscale(CENY, HEIGHT);

		StdDraw.clear(StdDraw.BLACK);

		//pass the inner planets to a new gravSystem
		solar = new GravitationalSystem(ListOfPlanets.getSolAndInners());
		//toggle the sun's static flag, so it is centered
		solar.bodies.get(0).toggleStaticPlanet();
		
		//I want to draw planet names only when I'm clearing the screen
		//Sometimes I turn clear off in order to debug orbits / make interesting art
		//try turning off clear and using left and right keys to switch central body!
		
		if (clear) {
			int i = 0;
			//setting names of planets from ListOfPlanets.java
			for (Body b : solar.bodies) {
				b.setName(ListOfPlanets.names[i]);
				i++;
			}
		}
		//Sun as central body
		statIndex = 0;
		
		//Main program loop
		while (running)	{
			//updateCamera(solar); //unused, may reimplement in the future

			StdDraw.enableDoubleBuffering();

			//checking for input, control camera, speed, etc.
			checkKeys();

			//setting 'position' of camera to center on a planet
			double[] camPos = solar.bodies.get(statIndex).scaleXandY(pixelsPerMeter);

			
			//if not central body
			//this is a WIP, trying to change camera functionality to make central body the frame of reference
			if (statIndex != 0) {
				double camDist = GravitationalSystem.distanceBetween(solar.bodies.get(statIndex), solar.bodies.get(0));
				
				StdDraw.setXscale(camPos[0] - CENX * centerscaleidk, camPos[0] + CENX * centerscaleidk);
				StdDraw.setYscale(camPos[1] - CENY * centerscaleidk, camPos[1] + CENY * centerscaleidk);
			} else {
				//centering screen on active body
				StdDraw.setXscale(camPos[0] - CENX * centerscaleidk, camPos[0] + CENX * centerscaleidk);
				StdDraw.setYscale(camPos[1] - CENY * centerscaleidk, camPos[1] + CENY * centerscaleidk);
			}

			//boolean flag to clear screen
			if (clear) {
				StdDraw.clear(StdDraw.BLACK);
			}
			//setting accelerations to zero to avoid unwanted orbits
			for (Body b : solar.bodies) {
				b.setAccelZero();
			}
			//update accelerations
			solar.update(timestep);
			//draw planets
			solar.draw(CENX, CENY, pixelsPerMeter);
			
			//draw text, names of planets, above the planets. a little buggy when zoomed out
			if (clear) {
				for (Body b : solar.bodies) {
					double[] loc = b.scaleXandY(pixelsPerMeter);
					StdDraw.setPenColor(StdDraw.WHITE);
					//I need to scale up the coordinates in order to get the right position
					StdDraw.text(loc[0], loc[1] + (b.radius * pixelsPerMeter * 6e6), b.name);
					// System.out.println());
				}
			}

			// solar.bodies.get(1).scaleXandY(pixelsPerMeter)[0];

			StdDraw.show();
			StdDraw.pause(frameRate);
		}
		System.exit(1);
	}

	//unused, WIP to reimplement
	public static void updateCamera(GravitationalSystem system) {

	}

	//function checks for any input
	public static void checkKeys() {
		
		//Switch focus to next planet (Actually, Body. includes sun.)
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
			
			//Make sure not to go out of bounds of arrayList
			if (statIndex == solar.bodies.size() - 1) {
				statIndex = 0;
			} else {
				statIndex += 1;
			}
			//Clear so that we don't get 'ghost' planets
			StdDraw.clear(StdDraw.BLACK);
			
		} 
		//Ditto, going backwards through ArrayList
		else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
			if (statIndex == 0) {
				//Check for OOB
				statIndex = solar.bodies.size() - 1;
			} else {
				statIndex -= 1;
			}
			StdDraw.clear(StdDraw.BLACK);
		}
		//Zoom in to simulation
		if (StdDraw.isKeyPressed(KeyEvent.VK_EQUALS)) {
			WIDTH -= CENX / scaleInc;
			HEIGHT -= CENY / scaleInc;
			CENX = WIDTH / 2;
			CENY = HEIGHT / 2;

			StdDraw.clear(StdDraw.BLACK);
		}
		
		//Zoom out of simulation
		if (StdDraw.isKeyPressed(KeyEvent.VK_MINUS)) {
			WIDTH += CENX / scaleInc;
			HEIGHT += CENY / scaleInc;
			CENX = WIDTH / 2;
			CENY = HEIGHT / 2;

			//avoid 'ghost' bodies
			StdDraw.clear(StdDraw.BLACK);
		}
		//Q to quit simulation
		if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
			running = !running;
		}
		//toggles 'clear' flag, shows trails of planets
		if (StdDraw.isKeyPressed(KeyEvent.VK_C)) {
			StdDraw.clear(StdDraw.BLACK);
			clear = !clear;
		}
		//increase speed of simulation. not technically framerate. smaller pause() == faster
		if (StdDraw.isKeyPressed(KeyEvent.VK_COMMA)) {
			if (frameRate > 0) {
				frameRate--;
			}
		}
		//decrease speed of simulation. higher == slower
		if (StdDraw.isKeyPressed(KeyEvent.VK_PERIOD)) {
			frameRate++;
		}
	}
}
