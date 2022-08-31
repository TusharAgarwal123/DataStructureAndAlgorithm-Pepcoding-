package com.ds.level2.DP;

//96. Unique Binary Search Trees

/*
* Given an integer. Find how many structurally unique binary search trees are there that stores the values
*  from 1 to that integer (inclusive). 
*/

//it is based on catalan number
public class UniqueBST {

	static int numTrees(int N) {
		// Your code goes here
		long MOD = 1000000007;
		long[] dp = new long[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int right = i - j - 1;
				long val = (dp[j] * dp[right]) % MOD;
				dp[i] = (dp[i] + val) % MOD;

			}
		}

		return (int) dp[N];

	}

}
