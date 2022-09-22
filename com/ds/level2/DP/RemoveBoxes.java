package com.ds.level2.DP;

//546. Remove Boxes

/*
 * You are given several boxes with different colors represented by different positive numbers.

You may experience several rounds to remove boxes until there is no box left. Each time you can choose
 some continuous boxes with the same color (i.e., composed of k boxes, k >= 1), remove them and get k * k points.

Return the maximum points you can get.


 */

public class RemoveBoxes {

	public int removeBoxes(int[] boxes) {

		int n = boxes.length;
		int[][][] dp = new int[n][n][n];
		return helper(boxes, 0, n - 1, 0, dp);

	}

	public int helper(int[] boxes, int i, int j, int k, int[][][] dp) {
		if (i > j) {
			return 0;
		}

		if (dp[i][j][k] != 0) {
			return dp[i][j][k];
		}

		int res = (k + 1) * (k + 1) + helper(boxes, i + 1, j, 0, dp);
		for (int m = i + 1; m <= j; m++) {
			if (boxes[m] == boxes[i]) {
				int fact = helper(boxes, i + 1, m - 1, 0, dp) + helper(boxes, m, j, k + 1, dp);

				res = Math.max(res, fact);
			}
		}

		dp[i][j][k] = res;
		return res;
	}

}
