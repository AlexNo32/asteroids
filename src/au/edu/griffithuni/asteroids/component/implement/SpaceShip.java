package au.edu.griffithuni.asteroids.component.implement;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.BOUNDARY;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRAME_WIDTH;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRANE_HEIGHT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_PAINT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_SHAPE;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.SPEEDS;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.DOWN;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.DOWNLEFT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.DOWNRIGHT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.LEFT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.RIGHT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.STOP;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.UP;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.UPLEFT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction.UPRIGHT;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import au.edu.griffithuni.asteroids.component.Element;
import au.edu.griffithuni.asteroids.component.GameUiManager;
import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction;

public class SpaceShip extends Element implements IComponent {
	
	private Point headPoint;
	private Direction headDirection;
	private int HP;
	
	public SpaceShip(GameUiManager gum) {
		this.gum = gum;
		initial();
	}

	/* draw spaceship in initial place */
	private void initial() {
		x = prev_x = FRAME_WIDTH / 2 - 25;
		y = prev_y = FRANE_HEIGHT * 3 / 4;

		radian = 0f;
		direction = STOP;
		HP = 2;
		setShape(J20_SHAPE);
		this.headPoint = shape[0];
		this.headDirection = UP;
	}

	@Override
	public void show(Graphics g) {
		if (live) {
			move();
			Point[] scp = Arrays.copyOf(shape, shape.length); 
			Point[] nscp = gem.fillPolygon(x, y, radian, scp[0], scp, J20_PAINT, g);
			headPoint = nscp[0];
		}
	}

	@Override
	public Rectangle getRect() {
		return new Rectangle(x, y, BOUNDARY, BOUNDARY);
	}
	
	public void fire() {
		gum.add(new Beam(gum, headPoint, headDirection));
	}

	public void move() {
		prev_x = x;
		prev_y = y;
		switch (direction) {
		case UP:
			y -= SPEEDS;
			radian = 0f;
			break;
		case DOWN:
			y += SPEEDS;
			radian = 180f;
			break;
		case LEFT:
			x -= SPEEDS;
			radian = 270f;
			break;
		case RIGHT:
			x += SPEEDS;
			radian = 90f;
			break;
		case UPLEFT:
			x -= SPEEDS;
			y -= SPEEDS;
			radian = 315f;
			break;
		case UPRIGHT:
			x += SPEEDS;
			y -= SPEEDS;
			radian = 45f;
			break;
		case DOWNLEFT:
			x -= SPEEDS;
			y += SPEEDS;
			radian = 225f;
			break;
		case DOWNRIGHT:
			x += SPEEDS;
			y += SPEEDS;
			radian = 135f;
			break;
		default:
			break;
		}
		if (direction != STOP)
			headDirection = direction;
		if (x < 0 || y < BOUNDARY || x > FRAME_WIDTH - BOUNDARY || y > FRANE_HEIGHT - BOUNDARY) {
			x = prev_x;
			y = prev_y;
		}
	}
	
	public void strike(ArrayList<IComponent> asteroids) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		/* move up */
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			goUp = true;
			break;
		/* move down */
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			goDown = true;
			break;
		/* move left */
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			goLeft = true;
			break;
		/* move right */
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			goRight = true;
			break;
		}
		setDirection();
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		/* open fire */
		case KeyEvent.VK_J:
		case KeyEvent.VK_SPACE:
			if (live)
				fire();
			break;
		/* move up */
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			goUp = false;
			break;
		/* move down */
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			goDown = false;
			break;
		/* move left */
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			goLeft = false;
			break;
		/* move right */
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			goRight = false;
			break;
		}
		setDirection();
	}

	private void setDirection() {
		if (goUp && !goDown && !goLeft && !goRight) {
			direction = UP;
		} else if (!goUp && goDown && !goLeft && !goRight) {
			direction = DOWN;
		} else if (!goUp && !goDown && goLeft && !goRight) {
			direction = LEFT;
		} else if (!goUp && !goDown && !goLeft && goRight) {
			direction = RIGHT;
		} else if (goUp && !goDown && goLeft && !goRight) {
			direction = UPLEFT;
		} else if (goUp && !goDown && !goLeft && goRight) {
			direction = UPRIGHT;
		} else if (!goUp && goDown && goLeft && !goRight) {
			direction = DOWNLEFT;
		} else if (!goUp && goDown && !goLeft && goRight) {
			direction = DOWNRIGHT;
		} else if (!goUp && !goDown && !goLeft && !goRight) {
			direction = STOP;
		}

	}

}
