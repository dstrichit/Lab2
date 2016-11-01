package com.dystricht.Lab2;

import java.awt.Color;
import java.util.ArrayList;

public class ListOfPlanets {
	public static final double AU = 1.49598e11;
	public static final double EM = 5.9736e24;
	public static final double KILO = 1000;
	public static final double pixelsPerMeter = 3/1e7;
	public static final int pixelScalar = 1500;

	public static ArrayList<Body> getPlanets() {
		ArrayList<Body> bodies = new ArrayList<Body>();
		bodies.add(mercury());
		bodies.add(venus());
		bodies.add(earth());
		bodies.add(mars());
		bodies.add(jupiter());
		bodies.add(saturn());
		bodies.add(uranus());
		bodies.add(neptune());
		bodies.add(pluto());

		return bodies;
	}
	
	public static ArrayList<Body> getSolAndInners() {
		ArrayList<Body> bodies = new ArrayList<Body>();
		bodies.add(sol());
		bodies.add(mercury());
		bodies.add(venus());
		bodies.add(earth());
		bodies.add(mars());
		bodies.get(0).toggleStaticPlanet();

		return bodies;
	}
	

	public static Body sol() {
		double mass = 1.98892e30;

		double distSun = 0;
		double x = distSun;
		double y = 0;
		double ax = 0;
		double ay = 0;
		double radius = 6.957e8;
		int pix = (int) (radius * pixelsPerMeter);
		Color c = new Color(244, 203, 66);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body earth() {
		double earthMass = EM;

		double distSun = AU;
		double earthx = distSun;
		double earthy = 0.0D;
		double radius = 6371000.0D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		double ax = 0.0D;
		double ay = 29790.0D;
		Color earthBlue = new Color(233, 37, 37);

		return new Body(earthMass, earthx, earthy, ax, ay, pix, earthBlue.getRed(), earthBlue.getGreen(),
				earthBlue.getBlue());
	}

	public static Body mercury() {
		double mass = 0.38 * EM;

		double distSun = 0.3871 * AU;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 48000.0D;
		double radius = 2439000.0D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body venus() {
		double mass = 0.81 * EM;

		double distSun = 0.7233 * AU;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 35000.0D;
		double radius = 6051000.0D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body mars() {
		double mass = 0.108 * EM;

		double distSun = 1.524 * AU;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 24140.0D;
		double radius = 3389000.0D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body jupiter() {
		double mass = 1.8985892879999998E27D;

		double distSun = 7.93318194E11D;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 13060.0D;
		double radius = 6.9911E7D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body saturn() {
		double mass = 5.67492E26D;

		double distSun = 1.427015322E12D;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 9640.0D;
		double radius = 5.8232E7D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body uranus() {
		double mass = 8.66172E25D;

		double distSun = 2.87078562E12D;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 6810.0D;
		double radius = 2.5362E7D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body neptune() {
		double mass = 1.02387504E26D;

		double distSun = 4.49691588e12;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 5430.0D;
		double radius = 2.4662E7D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}

	public static Body pluto() {
		double mass = 1.0752479999999998E24D;

		double distSun = 5.909121e12;
		double x = distSun;
		double y = 0.0D;
		double ax = 0.0D;
		double ay = 4700.0D;
		double radius = 2.0E7D;
		int pix = (int) (radius * pixelsPerMeter) * 1500;
		Color c = new Color(228, 228, 193);

		return new Body(mass, x, y, ax, ay, pix, c.getRed(), c.getGreen(), c.getBlue());
	}
}
