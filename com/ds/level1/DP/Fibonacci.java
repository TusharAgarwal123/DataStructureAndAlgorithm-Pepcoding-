package com.ds.level1.DP;

public class Fibonacci {

	public static void main(String[] args) throws Exception {
		// write your code here

		int n = 10;
		int dp[] = new int[n + 1];
		System.out.println(fibo(n));
		System.out.println(fiboDp(n, dp));
		System.out.println(fiboTabulation(n));

	}

	// recursive
	public static int fibo(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		int fibnm1 = fibo(n - 1);
		int fibnm2 = fibo(n - 2);
		int fibn = fibnm1 + fibnm2;

		return fibn;

	}

	// memorization
	public static int fiboDp(int n, int dp[]) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		int fibnm1 = fiboDp(n - 1, dp);
		int fibnm2 = fiboDp(n - 2, dp);
		int fibn = fibnm1 + fibnm2;
		dp[n] = fibn;
		return fibn;

	}

	// tabulation
	public static int fiboTabulation(int n) {

		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];

	}

}
