package com.ds.level2.DP;

//Friends Pairing Problem on gfg

/*
 * Given N friends, each one can remain single or can be paired up with some other friend. Each friend can
 *  be paired only once. Find out the total number of ways in which friends can remain single or can be
 *   paired up.
Note: Since answer can be very large, return your answer mod 10^9+7.
 */

public class FriendsPairingProblem {

	public long countFriendsPairings(int n) {
		// code here

		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		}
		long[] dp = new long[n + 1];

		dp[1] = 1;
		dp[2] = 2;

		int mod = 1000000007;

		for (int i = 3; i <= n; i++) {
			long val = ((i - 1) * dp[i - 2]) % mod; // if making pair
			dp[i] = (dp[i - 1] + val) % mod; // if coming single
		}

		return dp[n];
	}

}
