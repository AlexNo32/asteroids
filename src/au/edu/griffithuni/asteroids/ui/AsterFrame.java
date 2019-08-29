package au.edu.griffithuni.asteroids.ui;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRAME_TITLE;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRAME_WIDTH;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.FRANE_HEIGHT;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AsterFrame extends JFrame {

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
