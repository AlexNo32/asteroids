package au.edu.griffithuni.asteroids.component.animation;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FONT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.EXPLOSION;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.EXPLOSION_COLOR;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.graphicsengine.Polygon;

public class Explosion extends Polygon implements IComponent{

//	public Explosion(LinkedList<Point> vt, Color c, int font) {
////		super(new LinkedList<Point>(Arrays.asList(EXPLOSION)), EXPLOSION_COLOR, FONT);
//		
//	}

	public Explosion(Point[] vt, Color c, int font) {
		super(vt, c, font);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	

}
