package au.edu.griffithuni.asteroids.graphicsengine;

import java.awt.Graphics;
import java.awt.Point;
import java.util.HashSet;

/**
 * Line object, a series of pixels with certain direction
 * 
 * @author Firklaag_ins
 *
 */
public class Line extends Pixel {

	private Point start; // start point
	private Point end; // end point
	private HashSet<Pixel> line = new HashSet<Pixel>();// pixels container

	/**
	 * object constructor
	 * @param s:    line start position
	 * @param e:    line end position
	 * @param font: line font size
	 */
	public Line(Point s, Point e, int font) {
		super(font);
		this.start = s;
		this.end = e;
		
		line.add(new Pixel(s, font));
		dda();
	}

	/* dda algorithm */
	private void dda() {
		int dx = end.x - start.x;
		int dy = end.y - start.y;
		int h;

		if (Math.abs(dx) > Math.abs(dy))
			h = Math.abs(dx) / getFont();
		else
			h = Math.abs(dy) / getFont();

		float delta_x = dx / (float) h;
		float delta_y = dy / (float) h;

		float x = (float) start.x;
		float y = (float) start.y;

		for (int i = 0; i < h; i++) {
			x = x + delta_x;
			y = y + delta_y;
			line.add(new Pixel(new Point(round(x), round(y)), getFont()));
		}
	}

	// format the location into grid
	private int round(float i) {
		int font = getFont();
		return (int) (i + font / 2) / font * font;
	}

	/**
	 * paint all the pixels which form the line
	 */
	public void draw(Graphics g) {
		for (final Pixel p : line) {
			p.draw(g);
		}
	}

	public HashSet<Pixel> getLine() {
		return line;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

}
