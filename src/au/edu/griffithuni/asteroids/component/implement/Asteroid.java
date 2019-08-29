package au.edu.griffithuni.asteroids.component.implement;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.gamemanager.GameUiManager;
import au.edu.griffithuni.asteroids.graphicsengine.Polygon;

public class Asteroid implements IComponent{

	private Point vector;
	private Polygon block;
	
	private GameUiManager manager;
	private int prev_x, prev_y;
	private int x, y;
	
	private boolean live = true;
	
	public Asteroid(Point vector, int speed, Color c) {
		
	}
	
	private void move(){
		
	}
	
	@Override
	public void show(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
