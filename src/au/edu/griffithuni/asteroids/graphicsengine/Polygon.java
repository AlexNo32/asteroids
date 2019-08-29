package au.edu.griffithuni.asteroids.graphicsengine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import au.edu.griffithuni.asteroids.tools.Tools;

public class Polygon extends Pixel {

	private ArrayList<Triangle> subTri = new ArrayList<Triangle>(); // sub-triangle container
	private LinkedList<Vertex> vertex = new LinkedList<Vertex>(); // vertex container
	
	public Point[] points;
	/**
	 * constructor for Polygon
	 * @param vt LinkedList<Point>: vertex list for Polygon
	 * @param borderColor Color: border color
	 * @param fillColor Color: polygon color
	 * @param font Integer: font size of polygon
	 */
	public Polygon(Point[] vt, Color c, int font) {
		super(c, font);
		this.points = vt;
		// built vertex chain to assemble polygon
		setPolygon(new LinkedList<Point>(Arrays.asList(vt)));
		// decompose polygon into sub triangle
		decompose();
		
	}

	private void setPolygon(LinkedList<Point> vt) {
		Point head = vt.peekFirst();
		Point tail = vt.peekLast();
		vt.addFirst(tail);
		vt.addLast(head);

		for (int i = 1; i < vt.size() - 1; i++)
			vertex.add(new Vertex(vt.get(i), vt.get(i - 1), vt.get(i + 1)));

	}

	private void decompose() {
		while (!vertex.isEmpty()) {
			boolean va = true;

			if (vertex.size() == 3) {
				Point a, b, c;
				a = vertex.poll().getPos();
				b = vertex.poll().getPos();
				c = vertex.poll().getPos();
				subTri.add(new Triangle(a, b, c, getColor(), getFont()));

				break;
			}

			Vertex v = vertex.poll();
			if (v.isConvex()) {
				Point p, l, r;
				p = v.getPos();
				l = v.getLeft();
				r = v.getRight();

				for (Vertex t : vertex) {
					Point pt = t.getPos();

					if (!pt.equals(l) && !pt.equals(r))
						if (Tools.isInSide(pt, p, l, r))
							va = false;
				}

				if (va) {
					subTri.add(new Triangle(p, l, r, getColor(), getFont()));
					update(l, r);
				} else
					vertex.addLast(v);

			} else
				vertex.addLast(v);
		}
	}

	private void update(Point l, Point r) {
		for (Vertex t : vertex) {
			if (t.getPos() == l) {
				t.setLeft(r);
				t.updateConvex();
			}
			if (t.getPos() == r) {
				t.setLeft(l);
				t.updateConvex();
			}
				
		}
		
	}

	private HashSet<Pixel> getPolygon() {
		HashSet<Pixel> polygon = new HashSet<Pixel>();

		for (Triangle st : subTri)
			polygon.addAll(st.getTriangle());

		return polygon;
	}

	/* paint all the pixels which form the polygon */
	public void draw(Graphics g) {
		for (final Pixel p : getPolygon())
			p.draw(g);
	}

	public Point[] getPoints() {
		return points;
	}

	public void setPoints(Point[] points) {
		this.points = points;
	}

	/**
	 * 
	 * vertex object
	 * */
	private class Vertex {
		
		private Point pos; // vertex position
		private Point left; // left neighbor for vertex
		private Point right; // right neighbor for vertex
		private boolean convex; // is a convex vertex?

		/**
		 * 
		 * @param pos Point ,vertex point
		 * @param left Point, left neighbor of vertex
		 * @param right, Point right neighbor of vertex
		 */
		public Vertex(Point pos, Point left, Point right) {
			this.pos = pos;
			this.left = left;
			this.right = right;
			updateConvex();
		}

		/* extimate the vertex is convex or concave */
		public boolean shape() {
			return (right.x - left.x) * (pos.y - left.y) - (pos.x - left.x) * (right.y - left.y) > 0 ? false : true;
		}

		public void updateConvex() {
			this.convex = shape();
		}
		
		public Point getPos() {
			return pos;
		}

		public boolean isConvex() {
			return convex;
		}

		public Point getLeft() {
			return left;
		}

		public void setLeft(Point left) {
			this.left = left;
		}

		public Point getRight() {
			return right;
		}
	}

}
