package com.ds.leetcode.may;

//329. Longest Increasing Path in a Matrix
public class LongestIncreasingPathInAMatrix {

	int dp[][];
	int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {

		dp = new int[matrix.length][matrix[0].length];
		int ans = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				ans = Math.max(ans, dfs(matrix, i, j));
			}
		}

		return ans;

	}

	public int dfs(int[][] matrix, int i, int j) {

		if (dp[i][j] != 0) {
			return dp[i][j];
		}

		int max = 0;
		for (int d[] : dir) {
			int x = i + d[0];
			int y = j + d[1];

			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {

				max = Math.max(max, dfs(matrix, x, y));

			}

		}

		dp[i][j] = max + 1;

		return max + 1;

	}

}
