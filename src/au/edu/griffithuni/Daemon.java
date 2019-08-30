package au.edu.griffithuni;

import au.edu.griffithuni.asteroids.component.GameUiManager;

public class Daemon {

	private GameUiManager guiManager;

	public Daemon() {
		//do nothing
	}

	public void start() {
		guiManager = GameUiManager.getInstance();
		guiManager.gui();
	}

	//entrance
	public static void main(String[] args) {
		Daemon daemon = new Daemon();
		daemon.start();
	}
}
