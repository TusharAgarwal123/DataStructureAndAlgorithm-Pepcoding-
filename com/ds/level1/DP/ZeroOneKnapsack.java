package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
     overflowing it's capacity.

Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
               again and again.
 */

public class ZeroOneKnapsack {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int val[] = new int[n];
		int wts[] = new int[n];

		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			wts[i] = sc.nextInt();
		}

		int tar = sc.nextInt();

		System.out.println(solve(n, val, wts, tar));

	}

	public static int solve(int n, int val[], int wts[], int tar) {

		int dp[][] = new int[n + 1][tar + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {

				if (j >= wts[i - 1]) {

					int rCap = j - wts[i - 1];

					if (dp[i - 1][rCap] + val[i - 1] > dp[i - 1][j]) {
						dp[i][j] = dp[i - 1][rCap] + val[i - 1];
					} else {
						dp[i][j] = dp[i - 1][j]; // not including i.
					}

				} else {
					dp[i][j] = dp[i - 1][j]; // if i capacity > original capacity.
				}

			}
		}

		return dp[n][tar];

	}

}
