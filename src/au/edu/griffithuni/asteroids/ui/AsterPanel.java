package au.edu.griffithuni.asteroids.ui;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.*;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.COLOR_2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import au.edu.griffithuni.asteroids.component.GameUiManager;
import au.edu.griffithuni.asteroids.component.IComponent;
import au.edu.griffithuni.asteroids.component.implement.Beam;
import au.edu.griffithuni.asteroids.graphicsengine.GraphicsEngineManager;
import au.edu.griffithuni.asteroids.tools.Tools;

/**
 * Gui canvas
 * 
 * @author Firklaag_ins
 *
 */
public class AsterPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int N_STAR = 100; 
	/* Spaceship */
	private IComponent j20;
	/* asteroids list */
	private ArrayList<IComponent> asteroids = new ArrayList<IComponent>();
	/* beam list */
	private ArrayList<IComponent> beams = new ArrayList<IComponent>();
	/* explosion list */
	private ArrayList<IComponent> exps = new ArrayList<IComponent>();
	
	private AsterScoreLabel scb = new AsterScoreLabel();
	
	private GraphicsEngineManager gem = GraphicsEngineManager.getInstance();
	
	private ArrayList<Point> backgroundStar = new ArrayList<Point>();
	
	private GameUiManager gum;
	
	public AsterPanel(GameUiManager gum) {
		this.gum = gum;
		setLayout(null);
		add(scb);
		
		for(int i = 0; i < N_STAR; i++) {
			int x = Tools.randomInt(FRAME_WIDTH);
			int y = Tools.randomInt((int)(FRANE_HEIGHT * 0.8));
			backgroundStar.add(new Point(x, y));
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		background(g);
		stars(g);
		
		j20.show(g);
		j20.strike(asteroids);

		for (int i = 0; i < asteroids.size(); i++) {
			IComponent as = asteroids.get(i);
			as.show(g);
		}

		for (int i = 0; i < beams.size(); i++) {
			Beam bb = (Beam) beams.get(i);
			bb.show(g);
			bb.strike(asteroids);
		}
		
		for (int i = 0; i < exps.size(); i++) {
			exps.get(i).show(g);
		}

		scb.setScore(gum.getScore());
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
	
	private void stars(Graphics g) {
		for(int i = 0; i< N_STAR; i++) {
			Point p = backgroundStar.get(i);
			gem.drawPixel(p.x, p.y, 4, new Color(0,191,255), g);
		}
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

	public ArrayList<IComponent> getExps() {
		return exps;
	}

	public void setExps(ArrayList<IComponent> exps) {
		this.exps = exps;
	}

	private class AsterScoreLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private String msg = " Score: ";
		Font font=new Font("Arial",Font.BOLD, 20); 
		
		public AsterScoreLabel() {
			setBounds(1125, 25, 135, 35);
			setOpaque(true);
			setFont(font);
			setBackground(new Color(0, 191, 255));
			setScore(0);
		}
		
		public void setScore(int s) {
			setText(msg + s);
		}

	}

}
