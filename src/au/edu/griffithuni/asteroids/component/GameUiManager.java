package au.edu.griffithuni.asteroids.component;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import au.edu.griffithuni.asteroids.component.animation.Explosion;
import au.edu.griffithuni.asteroids.component.implement.Asteroid;
import au.edu.griffithuni.asteroids.component.implement.Beam;
import au.edu.griffithuni.asteroids.component.implement.SpaceShip;
import au.edu.griffithuni.asteroids.ui.AsterFrame;
import au.edu.griffithuni.asteroids.ui.AsterPanel;

public class GameUiManager implements ActionListener {

	private AsterFrame gui; // game frame
	private AsterPanel panel; // game panel

	private SpaceShip j20; // spaceship
	private List<Asteroid> asteroids = new ArrayList<Asteroid>(); // list of asteroids
	private List<Beam> beams = new ArrayList<Beam>(); // beams or bullets
	private List<Explosion> explodes = new ArrayList<Explosion>(); // explosion animation

	private Timer timer;
	private boolean pause = false;

	private GameUiManager() {
		initGui();
		initComponents();
	}

	/* init gui */
	private void initGui() {
		panel = new AsterPanel();
		gui = new AsterFrame();
		gui.getContentPane().add(panel);
		gui.addKeyListener(new GameKeyAdapter());
	}

	/* init game components */
	private void initComponents() {
		// add spaceship
		j20 = new SpaceShip(this);
		panel.getContent().add(j20);
		// add asteroids
		for (int i = 0; i < ASTEROID_NUMBRE; i++) {
			asteroids.add(new Asteroid()); 
		}
	}

	public void gui() {
		gui.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.repaint();
	}

	/**
	 * Starts the animation Key: F1
	 */
	private void startTimer(int resolution) {
		if (timer != null) {
			timer.stop();
			timer.setDelay(resolution);
		} else {
			timer = new Timer(resolution, this);
		}
		timer.start();
	}

	/**
	 * pause the game Key: F2
	 */
	private void pauseTimer() {
		if (timer != null) {
			if (pause && !timer.isRunning()) {
				timer.restart();
				pause = false;
			} else {
				timer.stop();
				pause = true;
			}
		}
	}

	/* Singleton */
	private static class SingletonHolder {
		private static final GameUiManager INSTANCE = new GameUiManager();
	}

	public static final GameUiManager getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/* Key listener */
	private class GameKeyAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			/* game start */
			case KeyEvent.VK_F1:
				startTimer(RESOLUTION);
				break;

			/* game pause */
			case KeyEvent.VK_F2:
				pauseTimer();
				break;

			default:
				j20.keyPressed(e);
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			j20.keyReleased(e);
		}

	}

	public List<Asteroid> getAsteroids() {
		return asteroids;
	}

	public void setAsteroids(List<Asteroid> asteroids) {
		this.asteroids = asteroids;
	}

	public List<Beam> getBeams() {
		return beams;
	}

	public void setBeams(List<Beam> beams) {
		this.beams = beams;
	}

	public List<Explosion> getExplodes() {
		return explodes;
	}

	public void setExplodes(List<Explosion> explodes) {
		this.explodes = explodes;
	}

}
