package com.ds.level2.DP;

//5. Longest Palindromic Substring

/*
 * Given a string s, return the longest palindromic substring in s.
 */

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {

		boolean dp[][] = new boolean[s.length()][s.length()];

		int ni = 0;
		int nj = 0;

		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < s.length(); j++, i++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {

					dp[i][j] = s.charAt(i) == s.charAt(j);

				} else {

					dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true;

				}

				if (dp[i][j]) {
					ni = i;
					nj = j;
				}
			}

		}

		return s.substring(ni, nj + 1);

	}

}
