package com.ds.level2.DP;

//940. Distinct Subsequences II

/*
 * Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very
 *  large, return it modulo 109 + 7.

A subsequence of a string is a new string that is formed from the original string by deleting some
 (can be none) of the characters without disturbing the relative positions of the remaining characters. 
 (i.e., "ace" is a subsequence of "abcde" while "aec" is not.
 */

public class DistinctSubsequencesII {

	long MOD = 1000000007;

	public int distinctSubseqII(String s) {

		long[] dp = new long[s.length() + 1];
		dp[0] = 1;
		dp[1] = 2;

		int[] lo = new int[26]; // last occurrence.
		lo[s.charAt(0) - 'a'] = 1;

		for (int i = 2; i < dp.length; i++) {
			dp[i] = (2 * dp[i - 1]) % MOD;

			int ch = s.charAt(i - 1) - 'a';
			if (lo[ch] != 0) {
				dp[i] = (dp[i] - dp[lo[ch] - 1] + MOD) % MOD;
			}
			lo[ch] = i;
		}

		return (int) dp[s.length()] - 1;

	}

}
