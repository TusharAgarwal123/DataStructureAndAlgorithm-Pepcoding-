package com.ds.level2.DP;

//647. Palindromic Substrings

/*
 * Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.
 */

public class PalindromicSubstrings {

	public int countSubstrings(String s) {

		if (s.length() == 0) {
			return 0;
		}

//		int ni=0;
//        int nj=0;

		boolean dp[][] = new boolean[s.length()][s.length()];
		int c = 0;

		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < s.length(); i++, j++) {
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				}

				if (dp[i][j]) {
					c++;
//					 ni=i;
//	                 nj=j;
				}
			}
		}

		// System.out.println(s.substring(ni,nj+1));

		return c;

	}

}
