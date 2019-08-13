package au.edu.griffithuni.asteroids.elements.animation;

import static au.edu.griffithuni.asteroids.tools.Contents.FONT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.EXPLOSION;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.EXPLOSION_COLOR;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

import au.edu.griffithuni.asteroids.elements.IElement;
import au.edu.griffithuni.asteroids.graphicsengine.Polygon;

public class Explosion extends Polygon implements IElement{

	public Explosion(LinkedList<Point> vt, Color c, int font) {
		super(new LinkedList<Point>(Arrays.asList(EXPLOSION)), EXPLOSION_COLOR, FONT);
		
	}

	@Override
	public void shape() {
		// TODO Auto-generated method stub
		
	}

}
