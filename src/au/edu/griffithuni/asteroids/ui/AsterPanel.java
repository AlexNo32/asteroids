package au.edu.griffithuni.asteroids.ui;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.COLOR_1;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.COLOR_2;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.component.implement.Beam;

/**
 * Gui canvas
 * @author Firklaag_ins
 *
 */
public class AsterPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	/* Spaceship */
	private IComponent j20;
	/* asteroids list */
	private ArrayList<IComponent> asteroids = new ArrayList<IComponent>();
	/* beam list */
	private ArrayList<IComponent> beams = new ArrayList<IComponent>();
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		background(g);
		
		j20.show(g);
		
		for(int i = 0; i < asteroids.size(); i++) {
			IComponent as = asteroids.get(i);
			as.show(g);
		}
		
		for(int i = 0; i < beams.size(); i++) {
			IComponent bb = beams.get(i);
			bb.show(g);
		}
			
	}
	
	/* set up the background */
	private void background(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, COLOR_1, 0, h, COLOR_2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
	}

	public IComponent getJ20() {
		return j20;
	}

	public void setJ20(IComponent j20) {
		this.j20 = j20;
	}

	public ArrayList<IComponent> getAsteroidsList() {
		return asteroids;
	}

	public void setAsteroids(ArrayList<IComponent> asteroids) {
		this.asteroids = asteroids;
	}

	public ArrayList<IComponent> getBeamsList() {
		return beams;
	}

	public void setBeams(ArrayList<IComponent> beams) {
		this.beams = beams;
	}

}
