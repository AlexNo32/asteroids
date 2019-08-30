package au.edu.griffithuni.asteroids.tools;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

public class Tools {

	private static Random random = new Random();
	
	/**
	 * {@link java.util.Random.nextInt(int bound)}
	 * @param bound boundary, [0, bound)
	 * @return
	 */
	public static int randomInt(int bound) {
		return random.nextInt(bound);
	}
	
	/**
	 * return a random color
	 * @return
	 */
	public static Color randomColor() {
		return new Color(randomInt(256), randomInt(256), randomInt(256));
	}
	
	public static int orientation(Point p, Point ls, Point le){
		int pt = (p.x - ls.x) * (le.y - ls.y) - (p.y - ls.y) * (le.x - ls.x);
		if(pt > 0) return 1;
		if(pt < 0) return -1;
		return 0;
	}
	
	public static boolean isSameSide(Point a, Point b, Point ls, Point le) {
		int apt = orientation(a, ls, le);
		int bpt = orientation(b, ls, le);
		return ((apt * bpt) > 0);
	}
	
	
	
	public static boolean isInSide(Point p, Point a, Point b, Point c) {
		return isSameSide(p, a, b, c) && isSameSide(p, b, a, c) && isSameSide(p, c, a, b);
	}
	
	public static double dist(Point a, Point b) {
		return Math.sqrt(Math.pow((b.getX() - a.getX()) ,2.0) + Math.pow((b.getY() - a.getY()) ,2));
	}

	
}
