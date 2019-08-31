package au.edu.griffithuni.asteroids.graphicsengine;

import java.awt.Point;

public class Matrix2DTransfer {

	/**
	 * 
	 * @param p base point
	 * @param v vector of translation
	 */
	public static Point translation(Point p, Point v) {
		return matrixMultiple(translationMatrices(v), transportMatrix(p));
	}

	/**
	 * 
	 * @param p base point
	 * @param s scaling rate
	 */
	public static Point scaling(Point p, float s) {
		return matrixMultiple(scalingMatrices(s), transportMatrix(p));
	}

	/**
	 * 
	 * @param p
	 * @param theta
	 */
	public static Point rotate(Point p, float theta, Point refer) {
		Point r;
		p.x -= refer.x;
		p.y -= refer.y;
		r = matrixMultiple(rotationMatrices(theta), transportMatrix(p));
		r.x += refer.x;
		r.y += refer.y;
		return r;
	}

	/**
	 * mapping around with x axis
	 * @param v vector 
	 * @return
	 */
	public static Point mappingAroundX(Point v) {
		return matrixMultiple(mappingMatricesX(), transportMatrix(v));
	}
	
	/**
	 * mapping around with y axis
	 * @param v vector 
	 * @return
	 */
	public static Point mappingAroundY(Point v) {
		return matrixMultiple(mappingMatricesY(), transportMatrix(v));
	}

	private static Point matrixMultiple(float[][] t, float[][] p) {
		float[][] r = new float[3][1];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 1; j++) {
				for (int k = 0; k < 3; k++) {
					r[i][j] += t[i][k] * p[k][j];
				}
			}
		}
		return new Point(Math.round(r[0][0]), Math.round(r[1][0]));
	}

	// transport matrix
	private static float[][] transportMatrix(Point p) {
		return new float[][] { { p.x }, { p.y }, { 1 } };
	}

	// return Translation matrices
	private static float[][] translationMatrices(Point v) {
		return new float[][] { { 1, 0, v.x }, { 0, 1, v.y }, { 0, 0, 1 } };
	}

	// return Scaling matrices
	private static float[][] scalingMatrices(float s) {
		return new float[][] { { s, 0, 0 }, { 0, s, 0 }, { 0, 0, 1 } };
	}

	private static float[][] rotationMatrices(float theta) {
		double cos = Math.cos((Math.PI * theta) / 180);
		double sin = Math.sin((Math.PI * theta) / 180);
		return new float[][] { { (float) cos, (float) -sin, 0 }, { (float) sin, (float) cos, 0 }, { 0, 0, 1 } };
	}

	private static float[][] mappingMatricesX(){
		return new float[][] {{1, 0, 0}, {0, -1, 0}, {0, 0, 1}};
	}
	
	private static float[][] mappingMatricesY(){
		return new float[][] {{-1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
	}
	
	public static void main(String[] args) {
		Point p = new Point(1, 3);
		System.out.println(mappingAroundX(p));
	}

}
