package com.ds.level2.DP;

//Circle And Chords on pepcoding

/*
 * 1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
 */

//it is also based on catalan number.
public class CircleAndChords {

	public static long solve(int n) {
		// write your code here

		int N = n;

		long[] dp = new long[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int right = i - j - 1;
				long val = (dp[j] * dp[right]);
				dp[i] = (dp[i] + val);

			}
		}

		return dp[N];

	}

}
