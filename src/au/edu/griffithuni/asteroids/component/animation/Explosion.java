package au.edu.griffithuni.asteroids.component.animation;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.EXPLOSION;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.EXPLOSION_COLOR;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

import au.edu.griffithuni.asteroids.component.Element;
import au.edu.griffithuni.asteroids.component.GameUiManager;
import au.edu.griffithuni.asteroids.component.IComponent;

/**
 * Explosion animation class
 * @author Firklaag_ins
 *
 */
public class Explosion extends Element implements IComponent {

	private int n = 15;

	public Explosion(int x, int y, GameUiManager gum) {
		this.gum = gum;
		this.x = x;
		this.y = y;
		setShape(EXPLOSION);
	}

	@Override
	public void show(Graphics g) {
		if (!live) {
			gum.remove(this);
			return;
		}
		Point[] scp = Arrays.copyOf(shape, shape.length);
		gem.fillPolygon(x, y, 0f, new Point(0, 0), scp, EXPLOSION_COLOR, g);
		move();
	}

	@Override
	public void move() {
		if (n-- < 0)
			destroy();
	}

	@Override
	public void destroy() {
		live = false;
	}

	@Override
	public Rectangle getRect() {
		return null;
	}

	@Override
	public void strike(ArrayList<IComponent> asteroids) {

	}
}
