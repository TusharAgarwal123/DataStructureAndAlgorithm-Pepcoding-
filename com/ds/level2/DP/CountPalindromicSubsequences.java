package com.ds.level2.DP;

//Count Palindromic Subsequences on gfg

/*
 * Given a string str of length N, you have to find number of palindromic subsequence (need not
 *  necessarily be distinct) present in the string str.
Note: You have to return the answer module 109+7;
 
 */

public class CountPalindromicSubsequences {

	long mod = 1000000007;

	long countPS(String str) {
		// Your code here

		long[][] dp = new long[str.length()][str.length()];

		for (int g = 0; g < dp[0].length; g++) {
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] + 1) % mod;
					} else {
						dp[i][j] = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1] + mod) % mod;
					}
				}
			}
		}

		return dp[0][dp[0].length - 1];

	}

}
