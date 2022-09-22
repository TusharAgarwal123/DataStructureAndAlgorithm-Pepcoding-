package com.ds.level2.DP;

//312. Burst Balloons

/*
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it
 *  represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes
 out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.
 */

public class BurstBalloons {

	public int maxCoins(int[] nums) {

		int[][] dp = new int[nums.length][nums.length];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {

				for (int lk = g + 1, rk = 1; lk >= 1; lk--, rk++) {
					int left = (lk == g + 1 ? 0 : dp[i][j - lk]);
					int right = (rk == g + 1 ? 0 : dp[i + rk][j]);

					int val = (i == 0 ? 1 : nums[i - 1]) * nums[i + rk - 1] * (j == nums.length - 1 ? 1 : nums[j + 1]);

					dp[i][j] = Math.max(dp[i][j], left + right + val);
				}

			}
		}

		return dp[0][nums.length - 1];

	}
}
