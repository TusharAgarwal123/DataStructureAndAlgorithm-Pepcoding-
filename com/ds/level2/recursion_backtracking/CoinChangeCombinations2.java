package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. You are given a number n, representing the count of coins.
2. You are given n numbers, representing the denominations of n coins.
3. You are given a number "amt".
4. You are required to calculate and print the combinations of the n coins (same coin can be used 
     again any number of times) using which the amount "amt" can be paid.
 */
public class CoinChangeCombinations2 {

	// on level we have coins each coin we can use atmost amt/coin times.
	public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf, int total) {
		if (i == coins.length) {
			if (amtsf == tamt) {
				System.out.println(asf + ".");
			}
			return;
		}

		for (int j = total / coins[i]; j > 0; j--) {
			String pasf = "";
			for (int k = 0; k < j; k++) {
				pasf += coins[i] + "-";
			}
			coinChange(i + 1, coins, amtsf + coins[i] * j, tamt, asf + pasf, total - coins[i] * j);
		}
		coinChange(i + 1, coins, amtsf, tamt, asf, total);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int amt = Integer.parseInt(br.readLine());
		coinChange(0, coins, 0, amt, "", amt);
	}

}
