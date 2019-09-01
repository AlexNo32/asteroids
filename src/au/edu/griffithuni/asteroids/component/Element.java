package au.edu.griffithuni.asteroids.component;

import java.awt.Point;

import au.edu.griffithuni.asteroids.graphicsengine.GraphicsEngineManager;
import au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction;

public abstract class Element implements IComponent{
	
	protected GameUiManager gum;
	protected GraphicsEngineManager gem = GraphicsEngineManager.getInstance();
	
	protected Point[] shape;
	protected int prev_x, prev_y;
	protected int x, y;
	protected float radian;
	protected boolean live = true;
	protected boolean goUp = false, goDown = false, goLeft = false, goRight = false;
	protected Direction direction;
	
	public abstract void move();

	public Point[] getShape() {
		return shape;
	}

	public void setShape(Point[] shape) {
		this.shape = shape;
	}
	
}
