package au.edu.griffithuni.asteroids.component;

import au.edu.griffithuni.asteroids.gamemanager.GameUiManager;
import au.edu.griffithuni.asteroids.graphicsengine.Polygon;

public abstract class GameElement {
	
	private Polygon block;
	private GameUiManager manager;
	private int prev_x, prev_y;
	private int x, y;
	
	private boolean live;

}
