package com.ds.level2.DP;

//Longest Repeating Subsequence on gfg.

/*
 * Given string str, find the length of the longest repeating subsequence such that it can be found twice 
 * in the given string.

The two identified subsequences A and B can use the same ith character from string str if and only if that
 ith character has different indices in A and B. For example, A = "xax" and B = "xax" then the index of first
  "x" must be different in the original string for A and B.
 */

public class LongestRepeatingSubsequence {

	public int LongestRepeatingSubsequence(String str) {
		// code here
		int[][] dp = new int[str.length() + 1][str.length() + 1];

		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				if (str.charAt(i) == str.charAt(j) && i != j) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		return dp[0][0];
	}

}
