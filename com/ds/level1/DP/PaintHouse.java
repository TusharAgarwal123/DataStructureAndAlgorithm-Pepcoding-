package com.ds.level1.DP;

import java.util.Scanner;

public class PaintHouse {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ar[][] = new int[n][3];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		long ans = paintHouse_Greedy(n, ar);

		System.out.println(ans);

	}

	public static long paintHouse_DP(int n, int ar[][]) {

		long dp[][] = new long[n][3];

		dp[0][0] = ar[0][0];
		dp[0][1] = ar[0][1];
		dp[0][2] = ar[0][2];

		for (int i = 1; i < n; i++) {
			dp[i][0] = ar[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = ar[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = ar[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

	}

	public static long paintHouse_Greedy(int n, int ar[][]) {

		long red = ar[0][0];
		long blue = ar[0][1];
		long green = ar[0][2];

		for (int i = 1; i < n; i++) {
			long nred = ar[i][0] + Math.min(blue, green);
			long nblue = ar[i][1] + Math.min(red, green);
			long ngreen = ar[i][2] + Math.min(red, blue);

			red = nred;
			blue = nblue;
			green = ngreen;
		}

		return Math.min(red, Math.min(blue, green));

	}

}
