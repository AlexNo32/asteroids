package au.edu.griffithuni.asteroids.tools;

import java.awt.Color;
import java.awt.Point;

public class ElementsSpecification {

	/**** System specification  ****/
	/* Frame size */
	public static final int FRAME_WIDTH = 1280;
	public static final int FRANE_HEIGHT = 960; 
	public static final String FRAME_TITLE = "Asteroids";
	/* pixel size */
	public static final int FONT = 1;
	/* background color */
	public static final Color COLOR_1 = new Color(0,0,0);
	public static final Color COLOR_2 = new Color(41,36,33); 
	public static final int RESOLUTION = 100; // FPS, 1000 / 50 frame per second
	
	
	/**** spaceship specification ****/
	/* Spaceship shape */
//	public static Point[] J20_SHAPE = { new Point(25, 0), new Point(35, 10), new Point(35, 25), new Point(50, 50),
//			new Point(0, 50), new Point(15, 25), new Point(15, 10) };
	public static final Point[] J20_SHAPE = { new Point(25, 0), new Point(35, 30), new Point(50, 40), new Point(25, 50),
			new Point(0, 40), new Point(15, 30) };
//	public static Color J20_PAINT = new Color(255, 69, 0); // Cadmium red
	public static final Color J20_PAINT = new Color(181, 180, 180); // 
	public static final int SPEEDS = 5; // spaceship move speed
//	public static final int BOUNDARY = 50;
	
	
	/**** Asteroid specification ****/
	public static final int ASTEROID_SIZE = 80;
	public static final int ASTEROID_VECTOR = 7;
	public static final int ASTEROID_NUMBRE = 9;
	
	/* explosion effect */
	public static final Point[] EXPLOSION = { new Point(0, 0), new Point(15, 8), new Point(30, 0), new Point(23, 15),
			new Point(30, 30), new Point(15, 23), new Point(0, 30), new Point(8, 15) };
	public static final Color EXPLOSION_COLOR = new Color(255, 215, 0);

	
	
	
	
	/* spaceship rectangle */
	public static final int SHAPE_SIZE = 50;
	
	/* spaceship direction */
	public static enum Direction {
		UP, DOWN, LEFT, RIGHT, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT, STOP
	};
}
