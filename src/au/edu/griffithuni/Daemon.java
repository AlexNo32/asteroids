package au.edu.griffithuni;

import au.edu.griffithuni.asteroids.gamemanager.GameUiManager;

public class Daemon {

	private GameUiManager guiManager;

	public Daemon() {
		//do nothing
	}

	public void start() {
		guiManager = GameUiManager.getInstance();
		guiManager.draw();
	}

	//entrance
	public static void main(String[] args) {
		Daemon daemon = new Daemon();
		daemon.start();
	}
}
