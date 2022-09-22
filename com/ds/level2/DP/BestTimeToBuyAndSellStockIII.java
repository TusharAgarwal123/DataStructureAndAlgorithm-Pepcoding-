package com.ds.level2.DP;

//123. Best Time to Buy and Sell Stock III

/*
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you
 buy again).


 */

public class BestTimeToBuyAndSellStockIII {

	public int maxProfit(int[] prices) {

		int[] dps = new int[prices.length]; // dp of if sell today.
		int lpsf = prices[0]; // if buy today

		dps[0] = 0; // on day 1 sell profit will be 0.

		for (int i = 1; i < prices.length; i++) {
			lpsf = Math.min(lpsf, prices[i]);
			int pist = prices[i] - lpsf; // profit if sale today.
			dps[i] = Math.max(pist, dps[i - 1]);
		}

		int[] dpb = new int[prices.length]; // dp of buying today.
		dpb[dpb.length - 1] = 0; // if buy on last day.

		int mpsf = prices[prices.length - 1];

		for (int i = prices.length - 2; i >= 0; i--) {
			mpsf = Math.max(mpsf, prices[i]);

			int pibt = mpsf - prices[i]; // profit if bought today.
			dpb[i] = Math.max(pibt, dpb[i + 1]);
		}

		int val = 0;

		for (int i = 0; i < prices.length; i++) {
			val = Math.max(val, (dps[i] + dpb[i]));
		}

		return val;

	}

}
