package au.edu.griffithuni.asteroids.tools;

import java.awt.Color;
import java.awt.Point;

public class ElementsSpecification {

	/* Spaceship shape */
	public static Point[] J20_SHAPE = { new Point(25, 0), new Point(35, 10), new Point(35, 25), new Point(50, 50),
			new Point(0, 50), new Point(15, 25), new Point(15, 10) };
	public static Color J20_PAINT = new Color(255, 69, 0); // Cadmium red

	/* explosion effect  */
	public static Point[] EXPLOSION = { new Point(0, 0), new Point(15, 8), new Point(30, 0), new Point(23, 15),
			new Point(30, 30), new Point(15, 23), new Point(0, 30), new Point(8, 15) };
	public static Color EXPLOSION_COLOR = new Color(255, 215, 0);

}
