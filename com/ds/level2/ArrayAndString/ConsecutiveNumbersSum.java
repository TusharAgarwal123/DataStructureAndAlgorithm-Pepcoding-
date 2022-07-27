package com.ds.level2.ArrayAndString;

//829. Consecutive Numbers Sum

/*
 * Given an integer n, return the number of ways you can write n as the sum of consecutive positive integers.
 */

public class ConsecutiveNumbersSum {

	public int consecutiveNumbersSum(int n) {

		int res = 0;

		int k = 1;
		int check = k * (k - 1) / 2;

		while (check < n) {
			if ((n - check) % k == 0) {
				res++;
			}
			k++;
			check = k * (k - 1) / 2;
		}

		return res;

	}

}
