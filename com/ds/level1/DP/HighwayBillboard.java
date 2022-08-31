package com.ds.level1.DP;

//Highway Billboard

/*
 * 1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.
 */

public class HighwayBillboard {

	public static int solution(int m, int[] x, int[] rev, int t) {

		int[] dp = new int[x.length];
		dp[0] = rev[0];

		for (int i = 1; i < dp.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (x[j] + t < x[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + rev[i];
		}

		int ans = 0;
		for (int val : dp) {
			ans = Math.max(ans, val);
		}

		return ans;
	}

}
