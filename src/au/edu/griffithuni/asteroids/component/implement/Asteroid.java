package au.edu.griffithuni.asteroids.component.implement;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.ASTEROID_SIZE;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.ASTEROID_VECTOR;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.AST_SPEED_LIMIT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.AST_SPEED_MAX;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import au.edu.griffithuni.asteroids.component.Element;
import au.edu.griffithuni.asteroids.component.GameUiManager;
import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.tools.Tools;

public class Asteroid extends Element implements IComponent{

	private Point vector;
	
	public Asteroid(GameUiManager gum) {
		this.gum = gum;
		init();
	}
	
	private void init() {
		// generate polygon shape
		Point[] s = new Point[ASTEROID_VECTOR];
		Astgenerator(ASTEROID_SIZE, ASTEROID_VECTOR).toArray(s);
		setShape(s);
		// genreate vector
		this.vector = new Point(Tools.randomInt(AST_SPEED_LIMIT, AST_SPEED_MAX), Tools.randomInt(AST_SPEED_LIMIT, AST_SPEED_MAX));
		// position init
		//TODO
	}
	
	@Override
	public void show(Graphics g) {
		if(live) {
			move();
			
//			System.out.println(x + " : " + y);
			
			Point[] scp = Arrays.copyOf(shape, shape.length); 
			gem.fillPolygon(x, y, 0, scp[0], scp, Color.RED, g);
		}
		
	}
	
	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void move() {
		prev_x = x;
		prev_y = y;
		
		x += vector.x;
		y += vector.y;
	}
	
	private LinkedList<Point> Astgenerator(int size, int vertex) {
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
}
