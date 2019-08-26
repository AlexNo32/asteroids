package au.edu.griffithuni.asteroids.gamemanager;

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

	private static final int RESOLUTION = 20; // FPS, 20 per second

	private AsterFrame gui; // game frame
	private AsterPanel panel; // game panel

	private SpaceShip j20; // spaceship
	private List<Asteroid> asteroids; // list of asteroids
	private List<Beam> beams; // beams or bullets

	Timer timer;

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

	}

	public void draw() {
		gui.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

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
			/* move up */
			case KeyEvent.VK_W:
			case KeyEvent.VK_UP:
				System.out.println("up");
				break;
			/* move left */
			case KeyEvent.VK_A:
			case KeyEvent.VK_LEFT:
				System.out.println("left");
				break;
			/* move down */
			case KeyEvent.VK_S:
			case KeyEvent.VK_DOWN:
				System.out.println("down");
				break;
			/* move right */
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
				System.out.println("right");
				break;
			/* open fire */
			case KeyEvent.VK_J:
			case KeyEvent.VK_SPACE:
				System.out.println("space");
				break;
			/* game start */
			case KeyEvent.VK_F1:
				startTimer(RESOLUTION);
				break;
			/* game pause */
			case KeyEvent.VK_F2:
				System.out.println("pause");
				break;
			}
		}

	}

}
