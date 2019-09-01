package au.edu.griffithuni.asteroids.component.implement;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.BEAM_COLOR;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.BEAM_SIZE;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.BEAM_SPEED;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRAME_WIDTH;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRANE_HEIGHT;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import au.edu.griffithuni.asteroids.component.Element;
import au.edu.griffithuni.asteroids.component.GameUiManager;
import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.tools.ElementsSpecification.Direction;

public class Beam extends Element implements IComponent{
	
	public Beam(GameUiManager gum, Point startPos, Direction dir) {
		this.gum = gum;
		this.x = startPos.x;
		this.y = startPos.y;
		direction = dir;
	} 
	
	@Override
	public void show(Graphics g) {
		if(!live) {
			gum.remove(this);
			return ;
		}
		gem.drawPixel(x, y, BEAM_SIZE, BEAM_COLOR, g);
		move();
	}

	@Override
	public void move() {
		switch (direction) {
		case UP:
			y -= BEAM_SPEED;
			break;
		case DOWN:
			y += BEAM_SPEED;
			break;
		case LEFT:
			x -= BEAM_SPEED;
			break;
		case RIGHT:
			x += BEAM_SPEED;
			break;
		case UPLEFT:
			x -= BEAM_SPEED;
			y -= BEAM_SPEED;
			break;
		case UPRIGHT:
			x += BEAM_SPEED;
			y -= BEAM_SPEED;
			break;
		case DOWNLEFT:
			x -= BEAM_SPEED;
			y += BEAM_SPEED;
			break;
		case DOWNRIGHT:
			x += BEAM_SPEED;
			y += BEAM_SPEED;
			break;
		default:
			break;
		}
		if (x < 0 || y < 0 || x > FRAME_WIDTH || y > FRANE_HEIGHT)
			this.live = false;
	}
	
	public void strike(ArrayList<IComponent> asteroids) {
		for(int i = 0; i < asteroids.size(); i++) {
			IComponent ast = asteroids.get(i);
			if(this.getRect().intersects(ast.getRect())) {
				gum.setScore(gum.getScore() + 1);
				destroy();
				ast.destroy();
			}
		}
	}
	
	@Override
	public Rectangle getRect() {
		return new Rectangle(x, y, BEAM_SIZE, BEAM_SIZE);
	}

	@Override
	public void destroy() {
		this.live = false;
		gum.remove(this);
	}

}
