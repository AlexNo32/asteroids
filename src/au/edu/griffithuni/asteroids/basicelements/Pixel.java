package au.edu.griffithuni.asteroids.basicelements;

import java.awt.Color;
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
	private Color color;// Pixel color
	private int font; // pixel font size

	/**
	 * basic object constructor
	 * @param c pixel color
	 * @param font pixel size
	 */
	public Pixel(Color c, int font) {
		this.font = font;
		this.color = Color.BLACK;
	}

	/**
	 * object constructor
	 * @param p:    pixel location
	 * @param c:    pixel color
	 * @param font: pixel font size
	 */
	public Pixel(Point p, Color c, int font) {
		this(c, font);
		this.point = p;
	}

	/**
	 * paint the actual pixel in certain color and font size
	 * @param g
	 */
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(color);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
