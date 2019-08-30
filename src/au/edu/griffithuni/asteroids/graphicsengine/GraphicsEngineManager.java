package au.edu.griffithuni.asteroids.graphicsengine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import au.edu.griffithuni.asteroids.tools.Tools;

public class GraphicsEngineManager {
	
	/**
	 * draw a polygon in certain shape
	 * @param x initial position x
	 * @param y initial position y
	 * @param radian the angle of polygon rotate [0f, 360f]
	 * @param reference reference point, the polygon rotates around this point
	 * @param track polygon track of lines
	 * @param c polygon color
	 * @param g {@link java.awt.Graphics} 
	 */
	public void fillPolygon(int x, int y, float radian, Point reference, Point[] track, Color c, Graphics g) {
		Point v = new Point(x, y);
		for(int i = 0; i < track.length; i++) {
			track[i] = Matrix2DTransfer.translation(track[i], v);
			track[i] = Matrix2DTransfer.rotate(track[i], radian, v);
		}
		
		LinkedList<Point> shape = new LinkedList<Point>(Arrays.asList(track));
		
		Polygon polygon = new Polygon(shape, 1);
		g.setColor(c);
		polygon.draw(g);
	}
	
	/**
	 * draw a random shape polygon
	 * @param x initial position x
	 * @param y y initial position y
	 * @param radian the angle of polygon rotate
	 * @param reference reference point, the polygon rotates around this point
	 * @param size polygon size, n * n rectangle 
	 * @param vertex number of vertex
	 * @param c polygon color
	 * @param g {@link java.awt.Graphics}
	 */
	public void fillRandomPolygon(int x, int y, float radian, Point reference, int size, int vertex, Color c, Graphics g) {
		LinkedList<Point> shape = randomPolygonGenerator(size, vertex);
		Polygon polygon = new Polygon(shape, 1);
		g.setColor(c);
		polygon.draw(g);
	}
	
	private LinkedList<Point> randomPolygonGenerator(int size, int vertex) {
		LinkedList<Point> bak = new LinkedList<Point>();
		LinkedList<Point> result = new LinkedList<Point>();
		
		for(int i = 0; i < vertex; i++)
			bak.add(new Point(Tools.randomInt(size), Tools.randomInt(size)));
		
		Point pa = bak.poll();
		Point pb = bak.poll();
		LinkedList<Point> left = new LinkedList<Point>();
		LinkedList<Point> right = new LinkedList<Point>();
		
		divide(bak, pa, pb, 1, left, right);

		result.addAll(partition(left, pa, pb));
		result.addAll(partition(right, pb, pa));
		return result;
		
	}
	
	private LinkedList<Point> partition(LinkedList<Point> part, Point pa, Point pb) {
		LinkedList<Point> result = new LinkedList<Point>();

		if (part.isEmpty()) {
			result.add(pa);
			return result;
		}

		Point spa = part.poll();
		Point fpa = feePoint(pa, pb);
		LinkedList<Point> sbuLeft = new LinkedList<Point>();
		LinkedList<Point> subRight = new LinkedList<Point>();

		int sign = Tools.orientation(fpa, spa, pa);
		divide(part, fpa, spa, sign, sbuLeft, subRight);

		result.addAll(partition(sbuLeft, pa, spa));
		result.addAll(partition(subRight, spa, pb));
		return result;
	}

	private Point feePoint(Point pa, Point pb) {
		return new Point((int) (pa.x + (pb.x - pa.x) * 0.5), (int) (pa.y + (pb.y - pa.y) * 0.5));
	}

	private void divide(List<Point> bak, Point pa, Point pb, int sign, List<Point> left, List<Point> right) {
		for (Point p : bak) {
			int r = sign * Tools.orientation(p, pa, pb);
			if (r > 0)
				left.add(p);
			else if (r < 0)
				right.add(p);
		}
	}
	
	private static class SingletonHolder {
		private static final GraphicsEngineManager INSTANCE = new GraphicsEngineManager();
	}

	public static final GraphicsEngineManager getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
}
