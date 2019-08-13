package au.edu.griffithuni.asteroids.component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static au.edu.griffithuni.asteroids.tools.Contents.*;
import javax.swing.JPanel;

public class AsterPanel extends JPanel implements IComponentBehavior, ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		background(g);
		
	}
	
	private void background(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, COLOR_1, 0, h, COLOR_2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
