package au.edu.griffithuni.asteroids.component;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public interface IComponent {
	
	public void show(Graphics g);
	
	public Rectangle getRect();
	
	public void strike(ArrayList<IComponent> asteroids);
	
	public void destroy();
}
