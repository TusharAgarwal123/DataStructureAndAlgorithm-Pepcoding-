package com.ds.level2.DP;

//Longest Common Substring on gfg.

/*
 * Given two strings. The task is to find the length of the longest common substring.


 */

public class LongestCommonSubstring {

	int longestCommonSubstr(String s1, String s2, int n, int m) {
		// code here
		int res = 0;

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = 0;
				}

				res = Math.max(res, dp[i][j]);
			}
		}

		return res;

	}

	int longestCommonSubstr2(String s1, String s2, int n, int m) {
		// code here
		int res = 0;

		int[][] dp = new int[s1.length()][s2.length()];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = 1 + ((i - 1 >= 0) && (j - 1 >= 0) ? dp[i - 1][j - 1] : 0);
					res = Math.max(res, dp[i][j]);
				}
			}
		}

		return res;

	}

}
