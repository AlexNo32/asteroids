package au.edu.griffithuni.asteroids.component;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import static au.edu.griffithuni.asteroids.tools.Contents.*;

public class AsterFrame extends JFrame implements IComponentBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void start() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(FRAME_TITLE);
		setSize(FRAME_WIDTH, FRANE_HEIGHT);
		setResizable(false);
		setVisible(true);
	}
	
	public void draw() {
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				start();
			}

		});
		
	}

}
