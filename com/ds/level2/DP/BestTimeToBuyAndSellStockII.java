package com.ds.level2.DP;

//122. Best Time to Buy and Sell Stock II

/*
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock
 at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
 */

public class BestTimeToBuyAndSellStockII {

	public int maxProfit(int[] prices) {

		int bd = 0; // buying date
		int sd = 0; // selling date
		int prof = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] >= prices[i - 1]) {
				sd = i;
			} else {
				prof += (prices[sd] - prices[bd]);
				bd = sd = i;
			}
		}

		prof += (prices[sd] - prices[bd]);

		return prof;
	}

}
