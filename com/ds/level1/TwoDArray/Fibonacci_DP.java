package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class Fibonacci_DP {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// System.out.println(fib(n));
		System.out.println(fiboMemorize(n, new int[n + 1]));
	}

	public static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static int fiboMemorize(int n, int dp[]) {

		if (n == 0 || n == 1) {
			return n;
		}
		if (dp[n] != 0) {
			return dp[n];
		}

		int ans = fiboMemorize(n - 1, dp) + fiboMemorize(n - 2, dp);
		dp[n] = ans;
		return ans;

	}

}
