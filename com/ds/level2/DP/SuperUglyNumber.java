package com.ds.level2.DP;

import java.util.Arrays;

//313. Super Ugly Number

/*
 * A super ugly number is a positive integer whose prime factors are in the array primes.

Given an integer n and an array of integers primes, return the nth super ugly number.

The nth super ugly number is guaranteed to fit in a 32-bit signed integer.


 */

public class SuperUglyNumber {

	public int nthSuperUglyNumber(int n, int[] primes) {

		long[] dp = new long[n + 1];
		dp[1] = 1;

		int[] idces = new int[primes.length];
		Arrays.fill(idces, 1);

		for (int i = 2; i <= n; i++) {
			long ans = Integer.MAX_VALUE;

			for (int j = 0; j < primes.length; j++) {
				int prime = primes[j];
				int idx = idces[j];
				ans = Math.min(ans, prime * dp[idx]);
			}

			dp[i] = ans;

			for (int j = 0; j < primes.length; j++) {
				int prime = primes[j];
				int idx = idces[j];
				if (ans == prime * dp[idx]) {
					idces[j] = idx + 1;
				}
			}
		}

		return (int) dp[n];

	}

}
