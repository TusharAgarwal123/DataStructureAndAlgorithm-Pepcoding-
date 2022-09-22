package com.ds.level2.DP;

//10. Regular Expression Matching

/*
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and
 *  '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
 */

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		int n = dp.length - 1;
		int m = dp[0].length - 1;

		for (int i = n; i >= 0; i--) {
			for (int j = m; j >= 0; j--) {
				if (i == n && j == m) {
					dp[i][j] = true;
				} else if (j == m) {
					dp[i][j] = false;
				} else if (i == n) {
					if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
						dp[i][j] = dp[i][j + 2];
					} else {
						dp[i][j] = false;
					}
				} else {
					if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
						if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
							dp[i][j] = dp[i + 1][j] || dp[i][j + 2];
						} else {
							dp[i][j] = dp[i][j + 2];
						}
					} else {
						if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
							dp[i][j] = dp[i + 1][j + 1];
						} else {
							dp[i][j] = false;
						}
					}

				}
			}
		}

		return dp[0][0];

	}

}
