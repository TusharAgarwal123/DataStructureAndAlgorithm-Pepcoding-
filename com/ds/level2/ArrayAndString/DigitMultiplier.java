package com.ds.level2.ArrayAndString;

//Digit multiplier on gfg

/*
 * Given a positive integer N, find the smallest number S such that the product of all the digits of S is
 *  equal to the number N. If there's no such number, Print "-1".
 */

public class DigitMultiplier {

	// O(logn)
	static String getSmallest(Long N) {
		// code here

		StringBuilder sb = new StringBuilder();

		if (N < 10) {
			return N + "";
		}

		for (int div = 9; div > 1; div--) {
			while (N % div == 0) {
				N = N / div;
				sb.append(div);
			}
		}

		if (N >= 10) { // (N>1) will also work
			return "-1";
		}

		return sb.reverse().toString();

	}

}
