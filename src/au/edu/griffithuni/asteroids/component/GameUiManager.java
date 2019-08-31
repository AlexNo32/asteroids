package au.edu.griffithuni.asteroids.component;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.ASTEROID_NUMBRE;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.RESOLUTION;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import au.edu.griffithuni.asteroids.component.implement.Asteroid;
import au.edu.griffithuni.asteroids.component.implement.Beam;
import au.edu.griffithuni.asteroids.component.implement.SpaceShip;
import au.edu.griffithuni.asteroids.ui.AsterFrame;
import au.edu.griffithuni.asteroids.ui.AsterPanel;

public class GameUiManager implements ActionListener {

	private AsterFrame gui; // game frame
	private AsterPanel panel; // game panel
	private SpaceShip j20;
	
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
		add(j20);
		
		// add asteroids
		for (int i = 0; i < ASTEROID_NUMBRE; i++) {
			add(new Asteroid(this)); 
		}
		
	}

	public void add(IComponent comp) {
		if(comp instanceof SpaceShip)
			panel.setJ20(comp);
		else if(comp instanceof Asteroid)
			panel.getAsteroidsList().add(comp);
		else if(comp instanceof Beam)
			panel.getBeamsList().add(comp);
	}
	
	public void remove(IComponent comp) {
		if(comp instanceof Asteroid)
			panel.getAsteroidsList().remove(comp);
		else if(comp instanceof Beam)
			panel.getBeamsList().remove(comp);
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
}
