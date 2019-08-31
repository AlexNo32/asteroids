package au.edu.griffithuni.asteroids.tools;

import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Tools {

	private static Random random = new Random();

	/**
	 * {@link java.util.Random.nextInt(int bound)}
	 * 
	 * @param bound boundary, [0, bound)
	 * @return random int
	 */
	public static int randomInt(int bound) {
		return random.nextInt(bound);
	}

	/**
	 * {@link java.util.Random.nextInt(int bound)}
	 * 
	 * @param lowerBound lower bound
	 * @param upperBound upper bound
	 * @return random int
	 */
	public static int randomInt(int lowerBound, int upperBound) {
		return randomInt(upperBound) - randomInt(lowerBound);
	}

	/**
	 * return a random color
	 * 
	 * @return
	 */
	public static Color randomColor() {
		return new Color(randomInt(256), randomInt(256), randomInt(256));
	}

	public static int orientation(Point p, Point ls, Point le) {
		int pt = (p.x - ls.x) * (le.y - ls.y) - (p.y - ls.y) * (le.x - ls.x);
		if (pt > 0)
			return 1;
		if (pt < 0)
			return -1;
		return 0;
	}

	public static boolean isSameSide(Point a, Point b, Point ls, Point le) {
		int apt = orientation(a, ls, le);
		int bpt = orientation(b, ls, le);
		return ((apt * bpt) > 0);
	}

	public static boolean isInSide(Point p, Point a, Point b, Point c) {
		return isSameSide(p, a, b, c) && isSameSide(p, b, a, c) && isSameSide(p, c, a, b);
	}

	public static double dist(Point a, Point b) {
		return Math.sqrt(Math.pow((b.getX() - a.getX()), 2.0) + Math.pow((b.getY() - a.getY()), 2));
	}

	public static void audioEffect() {
		
		try {
			URL url = Tools.class.getClassLoader().getResource("./audio/exp2.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		}

	}
	
}
