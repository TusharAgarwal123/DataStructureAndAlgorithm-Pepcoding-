package com.ds.level2.DP;

//474. Ones and Zeroes

/*
 * You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.
 */

public class OnesAndZeroes {

	public int findMaxForm(String[] strs, int m, int n) {

		int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

		return solve(strs, 0, m, n, dp);

	}

	public int solve(String[] strs, int i, int m, int n, int[][][] dp) {

		if (i == strs.length) {
			return 0;
		}

		if (dp[i][m][n] != 0) {
			return dp[i][m][n];
		}

		String str = strs[i];
		int cz = 0;
		int co = 0;

		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				cz++;
			} else {
				co++;
			}
		}

		int notInclude = solve(strs, i + 1, m, n, dp); // not including in set.

		int include = 0;

		if (cz <= m && co <= n) {
			include = 1 + solve(strs, i + 1, m - cz, n - co, dp); // including in set.
		}

		int res = Math.max(notInclude, include);

		dp[i][m][n] = res;

		return res;

	}

}
