package com.ds.level2.DP;

//188. Best Time to Buy and Sell Stock IV

/*
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and
 *  an integer k.

Find the maximum profit you can achieve. You may complete at most k transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy
 again).
 */

public class BestTimeToBuyAndSellStockIV {

	// O(n^2)
	public int maxProfit(int k, int[] prices) {

		if (prices.length == 0 || k == 0) {
			return 0;
		}

		int[][] dp = new int[k + 1][prices.length];

		for (int i = 1; i <= k; i++) {

			int maxp = Integer.MIN_VALUE;

			for (int j = 1; j < prices.length; j++) {

				maxp = Math.max(maxp, dp[i - 1][j - 1] - prices[j - 1]);
				dp[i][j] = Math.max(maxp + prices[j], dp[i][j - 1]);
			}
		}

		return dp[k][prices.length - 1];

	}

	// O(n^3)
	public int maxProfit2(int k, int[] prices) {

		if (prices.length == 0 || k == 0) {
			return 0;
		}

		int[][] dp = new int[k + 1][prices.length];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < prices.length; j++) {
				// jth day, ith transaction

				int maxp = 0;
				for (int jj = 0; jj < j; jj++) {
					maxp = Math.max(maxp, dp[i - 1][jj] + prices[j] - prices[jj]);
				}
				dp[i][j] = Math.max(maxp, dp[i][j - 1]);
			}
		}

		return dp[k][prices.length - 1];

	}

}
