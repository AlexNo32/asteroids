package au.edu.griffithuni.asteroids.graphicsengine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphicsEngineManager {
	
	/**
	 * draw a polygon in certain shape
	 * @param x initial position x
	 * @param y initial position y
	 * @param radian the angle of polygon rotate [0f, 360f]
	 * @param reference reference point, the polygon rotates around this point
	 * @param shape_cp copy of the polygon track of lines
	 * @param c polygon color
	 * @param g {@link java.awt.Graphics} 
	 * @return return the new shape after polygon transformation
	 */
	public Point[] fillPolygon(int x, int y, float radian, Point reference, Point[] shape_cp, Color c, Graphics g) {
		Point v = new Point(x, y);
		for(int i = 0; i < shape_cp.length; i++) {
			shape_cp[i] = Matrix2DTransfer.translation(shape_cp[i], v);
			shape_cp[i] = Matrix2DTransfer.rotate(shape_cp[i], radian, v);
		}
		
		LinkedList<Point> shape = new LinkedList<Point>(Arrays.asList(shape_cp));
		Polygon polygon = new Polygon(shape, 1);
		g.setColor(c);
		polygon.draw(g);
		
		return shape_cp;
	}
	
	/**
	 * 
	 * @param start start point for line
	 * @param end end point for line
	 * @param c color for line
	 * @param g {@link java.awt.Graphics}
	 */
	public void drawLine(Point start, Point end, Color c, Graphics g) {
		Line line = new Line(start, end, 1);
		g.setColor(c);
		line.draw(g);
	}
	
	/**
	 * 
	 * @param x pixel position x
	 * @param y pixel position y
	 * @param size pixel size
	 * @param c pixel color
	 * @param g {@link java.awt.Graphics}
	 */
	public void drawPixel(int x, int y, int size, Color c, Graphics g) {
		Point v = new Point(x, y);
		Pixel pixel = new Pixel(v, size);
		g.setColor(c);
		pixel.draw(g);
	}
	
	private static class SingletonHolder {
		private static final GraphicsEngineManager INSTANCE = new GraphicsEngineManager();
	}

	public static final GraphicsEngineManager getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
}
