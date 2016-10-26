package com.dystricht.Lab2;

import java.util.ArrayList;

public class GravitationalSystem {

	public final double GRAVCONST = 6.67384e-11;
	public ArrayList<Body> bodies;

	public GravitationalSystem(ArrayList<Body> bodyList) {

		bodies = bodyList;
	}

	public void addBody(Body newBody) {

		bodies.add(newBody);
	}

	public void update(double timestep) {
		
		// find acceleration of Body a caused by (all other)Body b, for each
		// Body a.
		for (Body a : bodies) {

			double[] totalAccels = new double[2];
			//a.setAccel();

			for (Body b : bodies) {
				// make sure no bodies affect their own velocity.
				if (b.equals(a)) {
					continue;
				} else {
					
					System.out.println("Calculated acceleration of Body "
							+ a.name + " by Body " + b.name);
					//totalAccels[0]
					
					//totalAccels = computeAcceleration(a, b);
					
					a.setAccel(computeAcceleration(a, b));
					
					//compute gravitational effects from every other body
					//double[] accelerations = computeAcceleration(a, b); //OLD way of updating accelerations
					//System.out.println("we're accelerating");
					
					//accels[i] = computeAcceleration(a, b);	
				}
				
			}
		}
		
		for (Body a : bodies){
			System.out.println("Adding accelerations to " + a.name);
			a.updateVelocity(timestep);
			a.updatePosition(timestep);
		}
	}

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
		
		double distX = a.x - b.x;
		double distY = a.y - b.y;
//		double distX = Math.abs(a.x - b.x);
//		double distY = Math.abs(a.y - b.y); // distance WRT x and y (distance is
											// abs value)
		
		//formula for acceleration of one body by another
		double acceleration = (GRAVCONST * b.mass) / Math.pow(distance, 2);
		
		double ax = -(acceleration * distX) / distance; // acceleration with
														// respect to X
		double ay = -(acceleration * distY) / distance; // acceleration with
														// respect to Y

		double[] accelerations = { ax, ay };

		return accelerations;

	}
	
	
	//distance between bodies - the distance formula
	public double distanceBetween(Body a, Body b){
		
		double distance = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
		
		return distance;
	}
}
