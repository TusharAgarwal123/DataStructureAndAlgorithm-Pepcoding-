package com.ds.leetcode.may;

//474. Ones and Zeroes
public class OnesAndZeroes {

	Integer dp[][][];

	public int findMaxForm(String[] strs, int m, int n) {

		// return solve(strs, 0, m, n);

		dp = new Integer[m + 1][n + 1][strs.length + 1];

		return solve(strs, 0, m, n);

	}

	// using recursion but it give tle
//	public int solve(String[] strs, int i, int m, int n) {
//
//		if (m < 0 || n < 0) {
//			return -1;
//		}
//
//		if (i == strs.length) {
//
//			return 0;
//		}
//
//		int ar[] = count(strs[i]);
//
//		// in subsets we have two choices to include item or not include.
//		int inc = solve(strs, i + 1, m - ar[0], n - ar[1]) + 1; // including
//		int NotInc = solve(strs, i + 1, m, n); // not including
//
//		return Math.max(inc, NotInc);
//
//	}

	// using memorization
	public int solve(String[] strs, int i, int m, int n) {

		if (m < 0 || n < 0) {
			return -1;
		}

		if (i == strs.length) {

			return 0;
		}

		if (dp[m][n][i] != null) {
			return dp[m][n][i];
		}

		int ar[] = count(strs[i]);

		// in subsets we have two choices to include item or not include.
		int in = solve(strs, i + 1, m - ar[0], n - ar[1]) + 1; // including
		int notIn = solve(strs, i + 1, m, n); // not including

		dp[m][n][i] = Math.max(in, notIn);

		return Math.max(in, notIn);

	}

	public int[] count(String str) {

		int zeros = 0;
		int ones = 0;

		for (char ch : str.toCharArray()) {
			if (ch == '0') {
				zeros++;
			} else {
				ones++;
			}
		}

		int ans[] = { zeros, ones };
		return ans;

	}

}
