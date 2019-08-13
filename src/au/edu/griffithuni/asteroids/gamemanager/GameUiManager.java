package au.edu.griffithuni.asteroids.gamemanager;

import javax.swing.SwingUtilities;

import au.edu.griffithuni.asteroids.component.AsterFrame;
import au.edu.griffithuni.asteroids.component.ComponentFactory;
import au.edu.griffithuni.asteroids.component.AsterPanel;

public class GameUiManager {

	private AsterFrame gui;
	private AsterPanel panel;
	
	private GameUiManager() {
		gui =   (AsterFrame) ComponentFactory.generator("Frame");
		panel = (AsterPanel) ComponentFactory.generator("Panel");
	}
	
	public void draw() {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				gui.getContentPane().add(panel);
				gui.start();
			}

		});
	}
	
	private static class SingletonHolder {  
        private static final GameUiManager INSTANCE = new GameUiManager();  
    }  
    
    public static final GameUiManager getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  

}
