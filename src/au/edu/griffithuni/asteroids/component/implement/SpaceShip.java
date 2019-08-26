package au.edu.griffithuni.asteroids.component.implement;

import static au.edu.griffithuni.asteroids.tools.Contents.FONT;
import static au.edu.griffithuni.asteroids.tools.Contents.FRAME_WIDTH;
import static au.edu.griffithuni.asteroids.tools.Contents.FRANE_HEIGHT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_PAINT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_SHAPE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.graphicsengine.Polygon;
import au.edu.griffithuni.asteroids.tools.Matrix2DTransfer;

public class SpaceShip implements IComponent{
	
	private Polygon block; 
//	private //Direction
	
	public SpaceShip(LinkedList<Point> vt, Color c, int font) {
		initial();

	}

	/* draw spaceship in initial place */
	private void initial() {
		List<Point> original = new LinkedList<Point>();
		int og_x = FRAME_WIDTH / 2 - 25;
		int og_y = FRANE_HEIGHT * 3 / 4;
		for(Point p: J20_SHAPE) {
			original.add(Matrix2DTransfer.translation(p, new Point(og_x, og_y)));
		}
		
		block = new Polygon((LinkedList<Point>) original, J20_PAINT, FONT);
	}
	
	public void move() {
		
	}
	
	public void fire() {
		
	}
	
	@Override
	public void show(Graphics g) {
		block.draw(g);
	}

	

}
