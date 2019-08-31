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
	public static final int RESOLUTION = 20; // FPS, 1000 / 50 frame per second
	
	
	/**** spaceship specification ****/
	/* Spaceship shape */
	public static final Point[] J20_SHAPE = { new Point(25, 0), new Point(35, 30), new Point(50, 40), new Point(25, 50),
			new Point(0, 40), new Point(15, 30) };
	public static final Color J20_PAINT = new Color(181, 180, 180); // Gery  new Color(255, 69, 0)Cadmium red
	public static final int SPEEDS = 5; // spaceship move speed
	public static final int BOUNDARY = 50; // spaceship rectangle
	/* spaceship direction */
	public static enum Direction {
		UP, DOWN, LEFT, RIGHT, UPLEFT, UPRIGHT, DOWNLEFT, DOWNRIGHT, STOP
	};
	
	
	
	/**** Asteroid specification ****/
	public static final int ASTEROID_SIZE = 100;
	public static final int ASTEROID_VECTOR = 6;
	public static final int AST_SPEED_LIMIT = 5;
	public static final int AST_SPEED_MAX = 15;
	public static final int ASTEROID_NUMBRE = 9;
	
	
	
	/**** Beam specification ****/
	public static final int BEAM_SIZE = 10;
	public static final int BEAM_SPEED = SPEEDS * 2;
	public static final Color BEAM_COLOR = new Color(255, 215, 0); // Yellow
	
	
	/* explosion effect */
	public static final Point[] EXPLOSION = { new Point(0, 0), new Point(15, 8), new Point(30, 0), new Point(23, 15),
			new Point(30, 30), new Point(15, 23), new Point(0, 30), new Point(8, 15) };
	public static final Color EXPLOSION_COLOR = new Color(255, 215, 0);

	
	
	
	
	
}
