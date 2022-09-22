package com.ds.level2.DP;

//44. Wildcard Matching

/*
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for
 *  '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
 */

public class WildcardMatching {

	public boolean isMatch(String s, String p) {

		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		int n = s.length();
		int m = p.length();

		for (int i = n; i >= 0; i--) {
			for (int j = m; j >= 0; j--) {

				if (i == n && j == m) {
					dp[i][j] = true;
				} else if (i == n) {
					if (p.charAt(j) == '*') {
						dp[i][j] = dp[i][j + 1];
					} else {
						dp[i][j] = false;
					}
				} else if (j == m) {
					dp[i][j] = false;
				} else {
					if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
						dp[i][j] = dp[i + 1][j + 1];
					} else if (p.charAt(j) == '*') {
						dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
					} else {
						dp[i][j] = false;
					}
				}

			}
		}

		return dp[0][0];

	}

}
