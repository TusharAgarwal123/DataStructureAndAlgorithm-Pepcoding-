package com.ds.level2.DP;

//1463. Cherry Pickup II

public class CherryPickupII {

	public int cherryPickup(int[][] grid) {

		Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];

		return helper(grid, 0, 0, grid[0].length - 1, dp);

	}

	public int helper(int[][] grid, int r1, int c1, int c2, Integer[][][] dp) {
		int r2 = r1;

		if (r1 >= grid.length || r2 >= grid.length || c1 < 0 || c2 < 0 || c1 >= grid[0].length
				|| c2 >= grid[0].length) {
			return 0;
		}

		if (dp[r1][c1][c2] != null) {
			return dp[r1][c1][c2];
		}

		int max = Integer.MIN_VALUE;

		max = Math.max(max, helper(grid, r1 + 1, c1 - 1, c2 - 1, dp));
		max = Math.max(max, helper(grid, r1 + 1, c1 - 1, c2, dp));
		max = Math.max(max, helper(grid, r1 + 1, c1 - 1, c2 + 1, dp));

		max = Math.max(max, helper(grid, r1 + 1, c1, c2 - 1, dp));
		max = Math.max(max, helper(grid, r1 + 1, c1, c2, dp));
		max = Math.max(max, helper(grid, r1 + 1, c1, c2 + 1, dp));

		max = Math.max(max, helper(grid, r1 + 1, c1 + 1, c2 - 1, dp));
		max = Math.max(max, helper(grid, r1 + 1, c1 + 1, c2, dp));
		max = Math.max(max, helper(grid, r1 + 1, c1 + 1, c2 + 1, dp));

		int res = max;

		res += grid[r1][c1];
		if (c1 != c2) {
			res += grid[r2][c2];
		}

		dp[r1][c1][c2] = res;
		return res;
	}

}
