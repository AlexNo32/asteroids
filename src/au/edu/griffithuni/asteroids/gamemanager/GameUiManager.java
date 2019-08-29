package au.edu.griffithuni.asteroids.gamemanager;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Timer;

import au.edu.griffithuni.asteroids.component.implement.Asteroid;
import au.edu.griffithuni.asteroids.component.implement.Beam;
import au.edu.griffithuni.asteroids.component.implement.SpaceShip;
import au.edu.griffithuni.asteroids.ui.AsterFrame;
import au.edu.griffithuni.asteroids.ui.AsterPanel;

public class GameUiManager implements ActionListener {

	private AsterFrame gui; // game frame
	private AsterPanel panel; // game panel

	private SpaceShip j20; // spaceship
	private List<Asteroid> asteroids; // list of asteroids
	private List<Beam> beams; // beams or bullets
	
	private Timer timer;
	private boolean gameOn;
	
	private GameUiManager() {
		initGui();
		initComponents();
	}

	private void initGui() {
		gui = new AsterFrame();
		panel = new AsterPanel();

		gui.getContentPane().add(panel);
		gui.addKeyListener(new GameKeyAdapter());
	}

	private void initComponents() {
		// add spaceship
		j20 = new SpaceShip(this);
		panel.getContent().add(j20);
		// add asteroids
		for(int i = 0; i < ASTEROID_NUMBRE; i++) {
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
	 * Starts the animation
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

	private void pauseTimer() {
		
	}
	
	private static class SingletonHolder {
		private static final GameUiManager INSTANCE = new GameUiManager();
	}

	public static final GameUiManager getInstance() {
		return SingletonHolder.INSTANCE;
	}

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
