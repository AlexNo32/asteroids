package au.edu.griffithuni.asteroids.component.implement;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FONT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRAME_WIDTH;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRANE_HEIGHT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_PAINT;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.J20_SHAPE;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.SHAPE_SIZE;
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
import java.awt.event.KeyEvent;

import au.edu.griffithuni.asteroids.component.Element;
import au.edu.griffithuni.asteroids.component.GameUiManager;
import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.graphicsengine.Matrix2DTransfer;
import au.edu.griffithuni.asteroids.graphicsengine.Polygon;
import au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction;

public class SpaceShip extends Element implements IComponent {

	public SpaceShip(GameUiManager gum) {
		this.gum = gum;
		initial();
	}

	/* draw spaceship in initial place */
	private void initial() {
		

//		Point[] shape = J20_SHAPE;
//		x = FRAME_WIDTH / 2 - 25;
//		y = FRANE_HEIGHT * 3 / 4;
//
//		for (int i = 0; i < shape.length; i++)
//			shape[i] = Matrix2DTransfer.translation(shape[i], new Point(x, y));
//
//		block = new Polygon(shape, J20_PAINT, FONT);
	}

	@Override
	public void show(Graphics g) {
		if (live) {
//			Point[] _pos = block.getPoints();
//
//			move();
//			Point v = new Point(x - prev_x, y - prev_y);
//
//			//veer();
////			if (turn) {
////				System.out.println(_pos[0]);
////				
////				/* rotate */
////				for (int i = 0; i < _pos.length; i++)
////					_pos[i] = Matrix2DTransfer.rotate(_pos[i], radian);
////				turn = false;
////				
////				System.out.println(_pos[0]);
////			}
//
//			/* translation */
//			for (int i = 0; i < _pos.length; i++)
//				_pos[i] = Matrix2DTransfer.translation(_pos[i], v);
//
//			block = new Polygon(_pos, J20_PAINT, FONT);
//			block.draw(g);
		}
	}

	

	public void fire() {

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
