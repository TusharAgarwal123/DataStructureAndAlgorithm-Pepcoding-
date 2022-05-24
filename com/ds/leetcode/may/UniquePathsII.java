package com.ds.leetcode.may;

//63. Unique Paths II
public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {

				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else if (i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = 1;
				} else if (i == dp.length - 1) {
					dp[i][j] = dp[i][j + 1];
				} else if (j == dp[0].length - 1) {
					dp[i][j] = dp[i + 1][j];
				} else {
					dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
				}
			}
		}

		return dp[0][0];

	}

}
