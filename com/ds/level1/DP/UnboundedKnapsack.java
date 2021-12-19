package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the count of items.
2. You are given n numbers, representing the values of n items.
3. You are given n numbers, representing the weights of n items.
3. You are given a number "cap", which is the capacity of a bag you've.
4. You are required to calculate and print the maximum value that can be created in the bag without 
    overflowing it's capacity.
Note -> Each item can be taken any number of times. You are allowed to put the same item again 
                  and again. 
 */

/*
 * Sample Input

5
15 14 10 45 30
2 5 1 3 4
7

Sample Output

100
 */
public class UnboundedKnapsack {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int val[] = new int[n];
		int wt[] = new int[n];
		for (int i = 0; i < n; i++) {
			val[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			wt[i] = sc.nextInt();
		}

		int tar = sc.nextInt();

		System.out.println(findMaxValue(n, val, wt, tar));

	}

	public static int findMaxValue(int n, int val[], int wt[], int tar) {

		int dp[] = new int[tar + 1];
		dp[0] = 0;

		for (int c = 1; c < dp.length; c++) {
			int max = 0;
			for (int i = 0; i < n; i++) {
				if (wt[i] <= c) {

					int rc = c - wt[i];
					int rv = dp[rc];
					int tv = rv + val[i];

					if (tv > max) {
						max = tv;
					}

				}
			}

			dp[c] = max;
		}

		return dp[tar];

	}
}
