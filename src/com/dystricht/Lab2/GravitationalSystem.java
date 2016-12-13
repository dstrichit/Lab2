package com.dystricht.Lab2;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class GravitationalSystem {

	public final double GRAVCONST = 6.67384e-11;
	public ArrayList<Body> bodies;
	public static double[] cameraPos = { 0, 0 };
	public static Random r = new Random();

	public GravitationalSystem(ArrayList<Body> bodyList) {

		//initialize GravSystem with an ArrayList of Bodies
		bodies = bodyList;
		for (Body b : this.bodies) {
			if (b.isStatic) {
				cameraPos = b.scaleXandY(Constants.pixelsPerMeter);
				break;
			}
		}
		
//		for(Body b : this.bodies){
//			b.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
//		}
	}

	//add a body to ArrayList. Goes unused.
	public void addBody(Body newBody) {

		bodies.add(newBody);
	}

	//update accelerations
	public void update(double timestep) {

		// find acceleration of Body a caused by (all other)Body b, for each Body a.
		// Utilizes nested forEach loops
		for (Body a : bodies) {
			//a.setAccelZero();
			double[] totalAccels = { 0, 0 };
			double[] adder = new double[2];

			for (Body b : bodies) {
				// make sure no bodies affect their own velocity.
				if (b.equals(a)) {
					continue;
				} else {
					// compute gravitational effects from every other body

					adder = computeAcceleration(a, b);
					totalAccels[0] += adder[0];
					totalAccels[1] += adder[1];

					//a.addAccel(adder);

				}

			}
			//add all accels from every body b on a single body a.
			a.addAccel(totalAccels);
			//then go to next body a.
		}

		//update velocity and position after calculating all accelerations
		for (Body a : bodies) {
			a.updateVelocity(timestep);
			a.updatePosition(timestep);
		}
	}

	//draw all bodies in ArrayList with respect to Center of screen
	public void draw(double cx, double cy, double pixelsPerMeter) {

		for (Body b : bodies) {
			b.draw(cx, cy, pixelsPerMeter);
		}
	}

	// implementation of acceleration of Body a caused by Body b
	public double[] computeAcceleration(Body a, Body b) { // must return 2
															// values: x and y
															// accelerations

		// distance between bodies
		double distance = distanceBetween(a, b);

		//if planets are too close, don't calculate accels
		//prevents extreme accelerations when planets get too close
		if (distance < 9e7) {
			return new double[] { 0, 0 };
		}

		//distance between bodies WRT x & y
		double distX = a.x - b.x;
		double distY = a.y - b.y;
		
		//total acceleration
		double acceleration = (GRAVCONST * b.mass) / Math.pow(distance, 2); // formula
																			// for
																			// acceleration
																			// of
																			// one
																			// body
																			// by
																			// another

		//acceleration WRT x & y
		double ax = -(acceleration * distX) / distance; // acceleration with
														// respect to X
		double ay = -(acceleration * distY) / distance; // acceleration with
														// respect to Y

		//returning array of accels to calling function
		double[] accelerations = { ax, ay };

		return accelerations;

	}

	// distance between bodies - the distance formula
	// useful in several different parts of this program
	public static double distanceBetween(Body a, Body b) {

		double distance = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));

		return distance;
	}
}
