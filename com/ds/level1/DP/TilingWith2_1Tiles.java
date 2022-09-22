package com.ds.level1.DP;

import java.util.Scanner;

//Tiling With 2 * 1 Tiles

/*
 * 1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
2. You've an infinite supply of 2 * 1 tiles.
3. You are required to calculate and print the number of ways floor can be tiled using tiles.

 */

public class TilingWith2_1Tiles {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		if (n == 0) {
			System.out.println(0);
		}

		int[] dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = 1;
			} else if (i == 2) {
				dp[i] = 2;
			} else {
				dp[i] = dp[i - 1] + dp[i - 2];
			}
		}

		System.out.println(dp[n]);

	}

}
