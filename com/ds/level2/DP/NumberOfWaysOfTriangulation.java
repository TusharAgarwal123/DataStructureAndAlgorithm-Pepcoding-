package com.ds.level2.DP;

//Number Of Ways Of Triangulation

/*
 * 1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.
 */

//it is based on catalan number.
public class NumberOfWaysOfTriangulation {

	public static int solution(int N) {
		// writeyour code here

		if (N < 3) {
			return 0;
		}

		N = N - 2;

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
