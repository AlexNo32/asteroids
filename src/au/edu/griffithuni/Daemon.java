package au.edu.griffithuni;

import au.edu.griffithuni.asteroids.component.GameUiManager;

public class Daemon {

	private GameUiManager guiManager = GameUiManager.getInstance();

	public Daemon() {
		//do nothing
	}

	public void start() {
		guiManager.gui();
	}

	//entrance
	public static void main(String[] args) {
		Daemon daemon = new Daemon();
		daemon.start();
	}
}
