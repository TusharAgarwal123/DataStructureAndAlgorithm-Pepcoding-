package com.ds.level2.DP;

//1143. Longest Common Subsequence

/*
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is
 *  no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none)
 deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
 */

public class LongestCommonSubsequence {

	public int longestCommonSubsequence(String text1, String text2) {

		int[][] dp = new int[text1.length() + 1][text2.length() + 1];

		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				if (text1.charAt(i) == text2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}

		return dp[0][0];

	}

}
