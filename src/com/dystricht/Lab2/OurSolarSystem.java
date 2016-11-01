package com.dystricht.Lab2;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class OurSolarSystem {
	public static double WIDTH = 3200, HEIGHT = 3200, CENX = WIDTH / 2, CENY = HEIGHT / 2;
	public static double scaleInc = 32;
	public static double centerscaleidk = 32;
	public static int frameRate = 2;
	public static boolean running = true, clear = false;
	public static int statIndex = 0;
	public static double WINCENTER;
	public static final double pixelsPerMeter = 3 / 1e7, timestep = 1e5 / 30;

	public static GravitationalSystem solar;

	public static void main(String[] args) {
		StdDraw.setXscale(CENX, WIDTH);
		StdDraw.setYscale(CENY, HEIGHT);

		StdDraw.clear(StdDraw.BLACK);

		solar = new GravitationalSystem(ListOfPlanets.getSolAndInners());

		statIndex = 0;
		while (running) {
			updateCamera(solar);

			checkKeys();

			double[] camPos = ((Body) solar.bodies.get(statIndex)).scaleXandY(pixelsPerMeter);
			StdDraw.setXscale(camPos[0] - CENX * centerscaleidk, camPos[0] + CENX * centerscaleidk);
			StdDraw.setYscale(camPos[1] - CENY * centerscaleidk, camPos[1] + CENY * centerscaleidk);

			StdDraw.enableDoubleBuffering();
			if (clear) {
				StdDraw.clear(StdDraw.BLACK);
			}
			for (Body b : solar.bodies) {
				b.setAccelZero();
			}
			solar.update(timestep);
			solar.draw(CENX, CENY, pixelsPerMeter);

			// solar.bodies.get(1).scaleXandY(pixelsPerMeter)[0];

			StdDraw.show();
			StdDraw.pause(frameRate);
		}
		System.exit(1);
	}

	public static void updateCamera(GravitationalSystem system) {
	}

	public static void checkKeys() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
			if (statIndex == solar.bodies.size() - 1) {
				statIndex = 0;
			} else {
				statIndex += 1;
			}
			StdDraw.clear(StdDraw.BLACK);
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
			if (statIndex == 0) {
				statIndex = solar.bodies.size() - 1;
			} else {
				statIndex -= 1;
			}
			StdDraw.clear(StdDraw.BLACK);
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_EQUALS)) {
			WIDTH -= CENX / scaleInc;
			HEIGHT -= CENY / scaleInc;
			CENX = WIDTH / 2;
			CENY = HEIGHT / 2;

			StdDraw.clear(StdDraw.BLACK);
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_MINUS)) {
			WIDTH += CENX / scaleInc;
			HEIGHT += CENY / scaleInc;
			CENX = WIDTH / 2;
			CENY = HEIGHT / 2;

			StdDraw.clear(StdDraw.BLACK);
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
			running = !running;
		}
		if (StdDraw.isKeyPressed(KeyEvent.VK_C)) {
			StdDraw.clear(StdDraw.BLACK);
		}
	}
}
