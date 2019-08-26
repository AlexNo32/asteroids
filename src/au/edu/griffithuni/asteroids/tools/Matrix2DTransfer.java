package au.edu.griffithuni.asteroids.tools;

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
		return 	matrixMultiple(scalingMatrices(s), transportMatrix(p));
	}

	/**
	 * 
	 * @param p
	 * @param theta
	 */
	public static Point rotate(Point p, float theta) {
		return matrixMultiple(rotationMatrices(theta), transportMatrix(p));
	}

	private static Point matrixMultiple(float[][] t, float[][] p) {
		float[][] r = new float[3][1];
		
		for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 3; k++) {
                    r[i][j] += t[i][k] * p[k][j];
                }
            }
        }
		return new Point(Math.round(r[0][0]), Math.round(r[1][0]));
	}
	
	// transport matrix
	private static float[][] transportMatrix(Point p){
		return new float[][] {{p.x}, {p.y}, {1}};
	}
	
	// return Translation matrices
	private static float[][] translationMatrices(Point v){
		return new float[][] {{1, 0, v.x}, {0, 1, v.y}, {0, 0, 1}};
	}
	
	// return Scaling matrices
	private static float[][] scalingMatrices(float s){
		return new float[][] {{s, 0, 0}, {0 ,s, 0}, {0, 0, 1}};
	}
	
	private static float[][] rotationMatrices(float theta){
		double cos = Math.abs(Math.cos((Math.PI * theta) / 180));
		double sin = Math.abs(Math.sin((Math.PI * theta) / 180));
		return new float[][] {{(float)cos, (float)-sin, 0}, {(float)sin, (float)cos, 0}, {0, 0, 1}};
	}
	
	/* ********debug************* */
	public static void main(String[] args) {
		Point t = new Point(-10, 10);
		Point r = new Point(4, 3);
		Point i = new Point(-3, -2);
		
		Point v = new Point(-5, 2);
		float s = 2.5f;
		
//		System.out.println(translation(t, v));
//		System.out.println(translation(r, v));
//		System.out.println(translation(i, v));
//		
//		System.out.println(scaling(t, s));
//		System.out.println(scaling(r, s));
//		System.out.println(scaling(i, s));
		
		System.out.println("0" + rotate(t, 0));
		System.out.println("45" + rotate(t, 45));
		System.out.println("90" + rotate(t, 90));
		System.out.println("135" + rotate(t, 135));
		System.out.println("180" + rotate(t, 180));
		System.out.println("225" + rotate(t, 225));
		System.out.println("270" + rotate(t, 270));
		System.out.println("315" + rotate(t, 315));
		System.out.println("360" + rotate(t, 360));
		
		
//		Point base = new Point(3, 5);
//		Point v = new Point(1, -1);
//		System.out.println(translation(base, v));
//		int r = 10;
//		System.out.println(scaling(base, r));
	}
	
}
