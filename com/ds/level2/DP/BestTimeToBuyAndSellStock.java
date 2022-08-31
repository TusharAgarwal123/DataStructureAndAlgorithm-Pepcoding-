package com.ds.level2.DP;

//121. Best Time to Buy and Sell Stock

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
 the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {

		int bp = prices[0]; // best buying point.
		int prof = 0;
		for (int i = 1; i < prices.length; i++) {
			bp = Math.min(bp, prices[i]);
			int pist = prices[i] - bp; // profit if sale today.
			prof = Math.max(prof, pist);
		}

		return prof;

	}
}
