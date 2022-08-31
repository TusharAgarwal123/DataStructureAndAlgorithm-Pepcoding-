package com.ds.level2.DP;

//714. Best Time to Buy and Sell Stock with Transaction Fee

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer
 *  fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to
 pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you
 buy again).
 */

public class BestTimeToBuyAndSellStockwithTransactionFee {

	public int maxProfit(int[] prices, int fee) {

		int obsp = -prices[0];
		int ossp = 0;

		for (int i = 1; i < prices.length; i++) {
			int nbsp = Math.max(ossp - prices[i], obsp);
			int nssp = Math.max(obsp + prices[i] - fee, ossp);

			obsp = nbsp;
			ossp = nssp;
		}

		return ossp;
	}

}
