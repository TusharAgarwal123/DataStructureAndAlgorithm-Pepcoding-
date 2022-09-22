package com.ds.level2.DP;

//115. Distinct Subsequences

/*
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of
 the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence
  of "ABCDE" while "AEC" is not).

The test cases are generated so that the answer fits on a 32-bit signed integer.


 */

public class DistinctSubsequences {

	public int numDistinct(String s, String t) {

		int[][] dp = new int[t.length() + 1][s.length() + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = 1;
				} else if (j == 0) {
					dp[i][j] = 0;
				} else {
					if (s.charAt(j - 1) == t.charAt(i - 1)) {
						dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				}
			}
		}

		return dp[t.length()][s.length()];

	}

}
