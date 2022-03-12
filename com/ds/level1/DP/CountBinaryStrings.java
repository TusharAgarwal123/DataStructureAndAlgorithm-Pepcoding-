package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n.
2. You are required to print the number of binary strings of length n with no consecutive 0's.
 */
public class CountBinaryStrings {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ans = countStringUsingGreedy(n);
		System.out.println(ans);

		// both approaches are efficient.

	}

	public static int countStringUsingDP(int n) {
		int dp0[] = new int[n + 1];
		int dp1[] = new int[n + 1];

		dp0[1] = 1;
		dp1[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp0[i] = dp1[i - 1];
			dp1[i] = dp1[i - 1] + dp0[i - 1];
		}

		return dp0[n] + dp1[n];
	}

	public static int countStringUsingGreedy(int n) {

		int c0 = 1;
		int c1 = 1;

		for (int i = 2; i <= n; i++) {
			int nc0 = c1;
			int nc1 = c0 + c1;

			c0 = nc0;
			c1 = nc1;
		}

		return c0 + c1;
	}

}
