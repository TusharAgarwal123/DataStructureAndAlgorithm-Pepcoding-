package com.ds.level2.DP;

//87. Scramble String

/*
 * We can scramble a string s to get a string t using the following algorithm:

If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to 
x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may 
become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise,
 return false.


 */

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		} else if (s1.equals(s2)) {
			return true;
		}

		int n = s1.length();

		boolean[][][] dp = new boolean[n][n][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i <= n - len; i++) {
				for (int j = 0; j <= n - len; j++) {
					if (len == 1) {
						dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
					} else {
						for (int k = 1; k <= len - 1; k++) {
							if (dp[i][j][len] == false) {
								boolean f1 = dp[i][j][k] && dp[i + k][j + k][len - k];
								boolean f2 = dp[i][j + len - k][k] && dp[i + k][j][len - k];

								dp[i][j][len] = f1 || f2;

							} else {
								break;
							}
						}
					}
				}
			}
		}

		return dp[0][0][n];

	}

}
