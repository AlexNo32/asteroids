package au.edu.griffithuni.asteroids.component;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRAME_WIDTH;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRANE_HEIGHT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.SHAPE_SIZE;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.SPEEDS;

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
	protected boolean live;
	protected boolean goUp = false, goDown = false, goLeft = false, goRight = false;
	protected Direction direction;
	
	protected void move() {
		prev_x = x;
		prev_y = y;
		switch (direction) {
		case UP:
			y -= SPEEDS;
			break;
		case DOWN:
			y += SPEEDS;
			break;
		case LEFT:
			x -= SPEEDS;
			break;
		case RIGHT:
			x += SPEEDS;
			break;
		case UPLEFT:
			x -= SPEEDS;
			y -= SPEEDS;
			break;
		case UPRIGHT:
			x += SPEEDS;
			y -= SPEEDS;
			break;
		case DOWNLEFT:
			x -= SPEEDS;
			y += SPEEDS;
			break;
		case DOWNRIGHT:
			x += SPEEDS;
			y += SPEEDS;
			break;
		default:
			break;
		}

		// TODO need debug
		if (x < 0 || y < SHAPE_SIZE || x > FRAME_WIDTH - SHAPE_SIZE || y > FRANE_HEIGHT - SHAPE_SIZE) {
			x = prev_x;
			y = prev_y;
		}
	}


}
