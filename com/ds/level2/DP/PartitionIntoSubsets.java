package com.ds.level2.DP;

//Partition Into Subsets

/*
 * 1. You are given a number n, representing the number of elements.
2. You are given a number k, representing the number of subsets.
3. You are required to print the number of ways in which these elements can be partitioned in k non-empty
 subsets.
E.g.
For n = 4 and k = 3 total ways is 6
12-3-4
1-23-4
13-2-4
14-2-3
1-24-3
1-2-34

 */

public class PartitionIntoSubsets {

	public static long partitionKSubset(int n, int k) {
		// write your code here

		if (n == 0 || k == 0 || n < k) {
			return 0;
		} else if (n == k) {
			return 1;
		}

		long[][] dp = new long[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j == 1) {
					dp[i][j] = 1;
				} else if (i < j) {
					dp[i][j] = 0;
				} else if (i == j) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j - 1] + j * dp[i - 1][j];
				}
			}
		}

		return dp[n][k];

	}

}
