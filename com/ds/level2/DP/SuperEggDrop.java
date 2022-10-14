package com.ds.level2.DP;

//887. Super Egg Drop

public class SuperEggDrop {

	// unoptimized
	public int superEggDrop(int k, int n) {

		int[][] dp = new int[k + 1][n + 1];

		for (int e = 0; e < dp.length; e++) {
			for (int f = 0; f < dp[0].length; f++) {
				if (e == 0) {
					// nothing
				} else if (e == 1) {
					dp[e][f] = f;
				} else if (f == 0) {
					dp[e][f] = 0;
				} else if (f == 1) {
					dp[e][f] = 1;
				} else {
					int best = Integer.MAX_VALUE;

					for (int k1 = 1; k1 <= f; k1++) {
						int sur = dp[e][f - k1];
						int brk = dp[e - 1][k1 - 1];
						int worst = Math.max(sur, brk);

						best = Math.min(best, worst);
					}

					dp[e][f] = best + 1;
				}
			}
		}

		return dp[k][n];

	}

}
