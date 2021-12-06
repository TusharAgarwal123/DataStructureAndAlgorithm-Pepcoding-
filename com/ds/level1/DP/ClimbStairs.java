package com.ds.level1.DP;

/*
 * 1. You are given a number n, representing the number of stairs in a staircase.
2. You are on the 0th step and are required to climb to the top.
3. In one move, you are allowed to climb 1, 2 or 3 stairs.
4. You are required to print the number of different paths via which you can climb to the top.
 */

public class ClimbStairs {

	public static void main(String[] args) throws Exception {
		// write your code here
		int n = 6;

		System.out.println(countPaths(n));

		System.out.println(countPathsMemorazation(n, new int[n + 1]));

		System.out.println(countPathsTabulation(n));

	}

	// recursive
	public static int countPaths(int n) {

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}

		int c1 = countPaths(n - 1);
		int c2 = countPaths(n - 2);
		int c3 = countPaths(n - 3);

		int c = c1 + c2 + c3;

		return c;

	}

	// memorization
	public static int countPathsMemorazation(int n, int dp[]) {

		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		int c1 = countPathsMemorazation(n - 1, dp);
		int c2 = countPathsMemorazation(n - 2, dp);
		int c3 = countPathsMemorazation(n - 3, dp);

		int c = c1 + c2 + c3;

		dp[n] = c;
		return c;

	}

	// tabulation
	public static int countPathsTabulation(int n) {

		int dp[] = new int[n + 1];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
		}

		return dp[n];

	}

}
