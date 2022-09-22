package com.ds.level2.DP;

//309. Best Time to Buy and Sell Stock with Cooldown

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy
 one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before
 you buy again).
 */

public class BestTimeToBuyAndSellStockwithCooldown {

	public int maxProfit(int[] prices) {

		int obsp = -prices[0];
		int ossp = 0;
		int ocsp = 0; // cooldown

		for (int i = 1; i < prices.length; i++) {
			int nbsp = Math.max(ocsp - prices[i], obsp);
			int nssp = Math.max(obsp + prices[i], ossp);
			int ncsp = Math.max(ossp, ocsp);

			obsp = nbsp;
			ossp = nssp;
			ocsp = ncsp;
		}

		return ossp;

	}

}
