package com.ds.level2.DP;

public class CatalanNumber {

	static int catalanNumber(int N) {

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
