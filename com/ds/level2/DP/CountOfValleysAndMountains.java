package com.ds.level2.DP;

//Count Of Valleys And Mountains

/*
 * 1. You are given a number n, representing the number of upstrokes / and number of downstrokes .
2. You are required to find the number of valleys and mountains you can create using strokes.
E.g.

 */

//it is based on catalan number.
public class CountOfValleysAndMountains {

	static int numberOfValleyAndMountains(int N) {

		int[] dp = new int[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int right = i - j - 1;
				int val = (dp[j] * dp[right]);
				dp[i] = (dp[i] + val);

			}
		}

		return dp[N];

	}

}
