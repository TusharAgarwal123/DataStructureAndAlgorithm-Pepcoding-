package com.ds.level2.DP;

//416. Partition Equal Subset Sum

/*
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into
 *  two subsets such that the sum of elements in both subsets is equal.
 */

public class PartitionEqualSubsetSum {

	public boolean canPartition(int[] nums) {

		int sum = 0;

		for (int x : nums) {
			sum += x;
		}

		if (sum % 2 == 1) {
			return false;
		}

		sum = sum / 2;

		return findSubsets(nums.length, nums, sum);

	}

	public static boolean findSubsets(int n, int ar[], int tar) {

		boolean dp[][] = new boolean[n + 1][tar + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = true; // every one can make the subset whose sum will be 0.
				} else if (i == 0) {
					dp[i][j] = false;
				} else {
					int val = ar[i - 1];
					if (dp[i - 1][j] == true) { // if don't assume the element in subset.
						dp[i][j] = true;
					} else {
						if (val <= j) {
							dp[i][j] = dp[i - 1][j - val];
						}
					}
				}
			}
		}

		return dp[n][tar];

	}

}
