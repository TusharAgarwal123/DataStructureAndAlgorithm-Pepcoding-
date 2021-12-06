package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add 
     up to "tar" or not.
 */

public class TargetSumSubsetsDP {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		int tar = sc.nextInt();

		System.out.println(findSubsets(n, ar, tar));

	}

	public static boolean findSubsets(int n, int ar[], int tar) {

		boolean dp[][] = new boolean[n + 1][tar + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (j == 0) {
					dp[i][j] = true;  //every one can make the subset whose sum will be 0.
				} else if (i == 0) {
					dp[i][j] = false;
				} else {
					int val = ar[i - 1];
					if (dp[i - 1][j] == true) { // if don't assume the element in subset.
						dp[i][j] = true;
					} else {
						if (val <= j) {
							dp[i][j] = dp[i - 1][j - val];
						}
					}
				}
			}
		}

		return dp[n][tar];

	}

}
