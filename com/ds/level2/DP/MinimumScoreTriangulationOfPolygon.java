package com.ds.level2.DP;

//1039. Minimum Score Triangulation of Polygon

/*
 * You have a convex n-sided polygon where each vertex has an integer value. You are given an integer array values where values[i] is the value of the ith vertex (i.e., clockwise order).

You will triangulate the polygon into n - 2 triangles. For each triangle, the value of that triangle is the product of the values of its vertices, and the total score of the triangulation is the sum of these values over all n - 2 triangles in the triangulation.

Return the smallest possible total score that you can achieve with some triangulation of the polygon.
 */

public class MinimumScoreTriangulationOfPolygon {
	public int minScoreTriangulation(int[] ar) {

		int[][] dp = new int[ar.length][ar.length];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {

				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = 0;
				} else if (g == 2) {
					dp[i][j] = ar[i] * ar[i + 1] * ar[i + 2];
				} else {
					dp[i][j] = Integer.MAX_VALUE;

					for (int lk = g - 1, rk = 1; lk >= 1; lk--, rk++) {
						int left = dp[i][j - lk];
						int right = dp[i + rk][j];

						int val = ar[i] * ar[i + rk] * ar[j];

						dp[i][j] = Math.min(dp[i][j], left + right + val);
					}
				}
			}
		}

		return dp[0][ar.length - 1];

	}

}
