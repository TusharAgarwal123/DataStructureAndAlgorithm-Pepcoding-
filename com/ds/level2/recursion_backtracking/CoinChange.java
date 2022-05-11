package com.ds.level2.recursion_backtracking;

/*
 * You are given an integer array coins representing coins of different
 *  denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
 If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 */
//leetcode 322
public class CoinChange {

	int min = Integer.MAX_VALUE;

	public int coinChange(int[] coins, int amount) {

		solve(coins, 0, amount, 0, amount, 0);
		return (min != Integer.MAX_VALUE ? min : -1);
	}

	public void solve(int[] coins, int i, int amt, int ssf, int total, int use) {

		if (ssf > amt) {
			return;
		}

		if (i == coins.length) {
			if (ssf == amt) {
				min = Math.min(min, use);
			}
			return;
		}

		for (int j = total / coins[i]; j >= 0; j--) {

			solve(coins, i + 1, amt, ssf + coins[i] * j, total - coins[i] * j, use + j);

		}

		// solve(coins,i+1,amt,ssf,total,use);
	}

}
