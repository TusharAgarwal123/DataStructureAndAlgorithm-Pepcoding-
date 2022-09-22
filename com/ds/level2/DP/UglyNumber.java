package com.ds.level2.DP;

//263. Ugly Number

/*
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.
 */

public class UglyNumber {

	public boolean isUgly(int n) {

		if (n == 0) {
			return false;
		}

		int[] divs = { 2, 3, 5 };

		for (int div : divs) {
			while (n % div == 0) {
				n = n / div;
			}
		}

		return n == 1;

	}

}
