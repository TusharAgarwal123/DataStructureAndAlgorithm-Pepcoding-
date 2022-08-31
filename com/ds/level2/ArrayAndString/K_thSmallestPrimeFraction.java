package com.ds.level2.ArrayAndString;

//786. K-th Smallest Prime Fraction

/*
 * You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr
 *  are unique. You are also given an integer k.

For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].

Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where
 answer[0] == arr[i] and answer[1] == arr[j].


 */

public class K_thSmallestPrimeFraction {

	public int[] kthSmallestPrimeFraction(int[] arr, int k) {

		double lo = 0.0;
		double hi = 1.0;

		int reqd = k;

		while (lo <= hi) {
			double mid = (lo + hi) / 2;
			int p = 0;
			int q = 1;

			int actual = 0;
			int j = 0;
			for (int i = 0; i < arr.length; i++) {
				while (j < arr.length && arr[i] > mid * arr[j]) {
					j++;
				}

				if (j == arr.length) {
					break;
				}

				actual += (arr.length - j);

				if (arr[i] * q > p * arr[j]) {
					p = arr[i];
					q = arr[j];
				}
			}

			if (actual < k) {
				lo = mid;
			} else if (actual > k) {
				hi = mid;
			} else {
				return new int[] { p, q };
			}
		}

		return null;

	}

}
