package au.edu.griffithuni.asteroids.graphicsengine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * Pixel object, base element for drawing line, triangle and polygon
 * 
 * @author Firklaag_ins
 *
 */
public class Pixel {

	private Point point; // pixel position
	private int font; // pixel font size

	/**
	 * basic object constructor
	 * @param font pixel size
	 */
	public Pixel(int font) {
		this.font = font;
	}

	/**
	 * object constructor
	 * @param p:    pixel location
	 * @param font: pixel font size
	 */
	public Pixel(Point p, int font) {
		this(font);
		this.point = p;
	}

	/**
	 * paint the actual pixel in certain color and font size
	 * @param g {@link java.awt.Graphics}
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.fillRect(point.x, point.y, font, font);
	}

	@Override
	public boolean equals(Object obj) {
		Pixel o = (Pixel) obj;
		return ((getPoint().x == o.getPoint().x) && (getPoint().y == o.getPoint().y));
	}

	@Override
	public int hashCode() {
		return getPoint().hashCode();
	}

	public int getFont() {
		return font;
	}

	public void setFont(int font) {
		this.font = font;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

}
