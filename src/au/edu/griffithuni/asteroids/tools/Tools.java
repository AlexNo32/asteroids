package au.edu.griffithuni.asteroids.tools;

import java.awt.Point;

public class Tools {

	public static int orientation(Point p, Point ls, Point le){
		int pt = (p.x - ls.x) * (le.y - ls.y) - (p.y - ls.y) * (le.x - ls.x);
		if(pt > 0) return 1;
		if(pt < 0) return -1;
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
		return Math.sqrt(Math.pow((b.getX() - a.getX()) ,2.0) + Math.pow((b.getY() - a.getY()) ,2));
	}

	 public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix, int r1, int c1, int c2) {
	        int[][] product = new int[r1][c2];
	        for(int i = 0; i < r1; i++) {
	            for (int j = 0; j < c2; j++) {
	                for (int k = 0; k < c1; k++) {
	                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
	                }
	            }
	        }
	        return product;
	    }
	
}
