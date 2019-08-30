package au.edu.griffithuni.asteroids.graphicsengine;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Triangle element
 * @author Firklaag_ins
 *
 */
public class Triangle extends Pixel {

	private Point pa, pb, pc; // vertex a, b, c
	
	@SuppressWarnings("unused")
	private int uBoundX; // upper boundary for x
	@SuppressWarnings("unused")
	private int lBoundX; // lower boundary for x
	
	private int uBoundY; // upper boundary for y
	private int lBoundY; // lower boundary for y

	private HashSet<Pixel> triangle = new HashSet<Pixel>(); //pixels container

	/**
	 * constructor for Triangle
	 * 
	 * @param pa Point: vertex a
	 * @param pb Point: vertex b
	 * @param pc Point: vertex c
	 * @param font Integer: font size of triangle
	 */
	public Triangle(Point pa, Point pb, Point pc, int font) {
		super(font);
		this.pa = pa;
		this.pb = pb;
		this.pc = pc;
		
		List<Integer> xl = Arrays.asList(pa.x, pb.x, pc.x);
		List<Integer> yl = Arrays.asList(pa.y, pb.y, pc.y);
		this.uBoundX = Collections.max(xl);
		this.lBoundX = Collections.min(xl);
		this.uBoundY = Collections.max(yl);
		this.lBoundY = Collections.min(yl);

		built();
	}

	private void built() {
		drawBorder();
		fillTriangleScaner();
	}

	private void drawBorder() {
		triangle.addAll(new Line(pa, pb, getFont()).getLine());
		triangle.addAll(new Line(pc, pb, getFont()).getLine());
		triangle.addAll(new Line(pa, pc, getFont()).getLine());
	}

	/* line scaner method for fill the triangle*/
	private void fillTriangleScaner() {
		HashMap<Integer, TreeSet<Integer>> border = borderTable();
		int l = lBoundY;

		while ((l += getFont()) < uBoundY) {
			TreeSet<Integer> gaps = border.get(l);
			
			int first = gaps.first();
			int last = gaps.last();

			while ((first += getFont()) < last) {
				triangle.add(new Pixel(new Point(first, l), getFont()));
			}
		}

	}

	// TODO occupied too much memory, planning fix in next ver.
	/* generator border table */
	private HashMap<Integer, TreeSet<Integer>> borderTable() {
		HashMap<Integer, TreeSet<Integer>> bTable = new HashMap<Integer, TreeSet<Integer>>();

		for (Iterator<Pixel> pls = triangle.iterator(); pls.hasNext();) {
			Pixel p = pls.next();
			int tx = p.getPoint().x;
			int ty = p.getPoint().y;

			if (bTable.containsKey(ty)) {
				bTable.get(ty).add(tx);
			} else {
				TreeSet<Integer> dist = new TreeSet<Integer>();
				dist.add(tx);
				bTable.put(ty, dist);
			}
		}
		return bTable;
	}
	
	/**
	 * paint all the pixels which form the line
	 */
	public void draw(Graphics g) {
		for (final Pixel s : triangle) {
			s.draw(g);
		}
	}
	
	/* return pixels to draw a triangle */
	public HashSet<Pixel> getTriangle() {
		return triangle;
	}

}
