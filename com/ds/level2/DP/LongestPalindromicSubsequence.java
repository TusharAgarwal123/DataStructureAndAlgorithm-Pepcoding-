package com.ds.level2.DP;

//516. Longest Palindromic Subsequence

/*
 * Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
 changing the order of the remaining elements.
 */

public class LongestPalindromicSubsequence {

	public int longestPalindromeSubseq(String str) {

		int[][] dp = new int[str.length()][str.length()];

		int max = 0;

		for (int g = 0; g < dp[0].length; g++) {
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
					}
				}

				if (dp[i][j] > max) {
					max = dp[i][j];
				}
			}
		}

		return max;

	}

}
