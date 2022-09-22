package com.ds.level2.DP;

//688. Knight Probability in Chessboard

/*
 * Given an NxN chessboard and a Knight at position (x, y). The Knight has to take exactly K steps, where
 *  at each step it chooses any of the 8 directions uniformly at random. Find the probability that the Knight
 *   remains in the chessboard after taking K steps, with the condition that it cant enter the board again
 *    once it leaves it.
 */

public class ProbabilityOfKnight {

	public double findProb(int N, int x, int y, int step) {
		// Code here
		double[][][] dp = new double[N][N][step + 1];

		int[][] dirs = { { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 } };

		dp[x][y][0] = 1;

		for (int move = 1; move <= step; move++) {
			for (int i = 0; i < dp.length; i++) {
				for (int j = 0; j < dp[0].length; j++) {
					for (int[] dir : dirs) {
						int xx = i + dir[0];
						int yy = j + dir[1];

						if (xx >= 0 && xx < N && yy >= 0 && yy < N) {
							dp[xx][yy][move] += dp[i][j][move - 1] / 8;
						}
					}
				}
			}
		}

		double res = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				res += dp[i][j][step];
			}

		}

		return res;

	}

}
