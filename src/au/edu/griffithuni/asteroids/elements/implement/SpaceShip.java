package au.edu.griffithuni.asteroids.elements.implement;

import static au.edu.griffithuni.asteroids.tools.Contents.FONT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_PAINT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_SHAPE;

import java.awt.Color;
import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;

import au.edu.griffithuni.asteroids.elements.IElement;
import au.edu.griffithuni.asteroids.graphicsengine.Polygon;

public class SpaceShip extends Polygon implements IElement{
	
	public SpaceShip(LinkedList<Point> vt, Color c, int font) {
		super(new LinkedList<Point>(Arrays.asList(J20_SHAPE)), J20_PAINT, FONT);

	}

	@Override
	public void shape() {
		
		
	}

}
