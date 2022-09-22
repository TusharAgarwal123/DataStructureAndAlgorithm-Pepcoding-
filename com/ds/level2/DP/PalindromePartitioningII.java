package com.ds.level2.DP;

//132. Palindrome Partitioning II

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.
 */

public class PalindromePartitioningII {

	// O(n^3).
	public int minCut(String s) {

		int[][] dp = new int[s.length()][s.length()];

		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {

				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 0;
					} else {
						dp[i][j] = 1;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 0) { // means whole string is palindrome.
						dp[i][j] = 0;
					} else {
						dp[i][j] = Integer.MAX_VALUE;
						for (int lk = g, rk = 1; lk >= 1; lk--, rk++) {
							int left = dp[i][j - lk];
							int right = dp[i + rk][j];
							int val = left + right + 1;
							dp[i][j] = Math.min(dp[i][j], val);

						}
					}
				}

			}
		}

		return dp[0][s.length() - 1];

	}

	boolean[][] ip;

	public boolean[][] isPalindrome(String s) {

		ip = new boolean[s.length()][s.length()];

		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < ip.length; i++, j++) {
				if (g == 0) {
					ip[i][j] = true;
				} else if (g == 1) {
					ip[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					ip[i][j] = s.charAt(i) == s.charAt(j) && ip[i + 1][j - 1];

				}
			}
		}

		return ip;
	}

	// optimized approach
	// O(n^2)
	public int minCut2(String s) {

		if (s.length() <= 1) {
			return 0;
		}

		isPalindrome(s);

		int[] dp = new int[s.length()];

		dp[0] = 0;
		dp[1] = s.charAt(0) == s.charAt(1) ? 0 : 1;

		for (int j = 2; j < dp.length; j++) {
			dp[j] = j;

			if (ip[0][j]) {
				dp[j] = 0;
			} else {
				for (int i = j; i > 0; i--) {
					if (ip[i][j]) {
						dp[j] = Math.min(dp[j], dp[i - 1] + 1);
					}
				}
			}
		}

		return dp[dp.length - 1];
	}

}
