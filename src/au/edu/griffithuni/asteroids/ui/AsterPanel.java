package au.edu.griffithuni.asteroids.ui;

import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.COLOR_1;
import static au.edu.griffithuni.asteroids.tools.ElementsSpecification.COLOR_2;

import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import au.edu.griffithuni.asteroids.component.IComponent;

public class AsterPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<IComponent> content = new ArrayList<IComponent>();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		background(g);
		for(IComponent p: content)
			p.show(g);
		
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

	public ArrayList<IComponent> getContent() {
		return content;
	}

	public void setContent(ArrayList<IComponent> content) {
		this.content = content;
	}
	
}
