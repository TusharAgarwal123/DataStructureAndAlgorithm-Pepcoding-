package com.ds.level2.DP;

//233. Number of Digit One

/*
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less
 *  than or equal to n.


 */

public class NumberOfDigitOne {

	public int countDigitOne(int n) {

		int res = 0;
		int place = 1;

		while (place <= n) {
			int q = n / (10 * place);
			int r = n % (10 * place);

			int extra = 0;
			if (r >= 2 * place) {
				extra = place;
			} else if (r >= place) {
				extra = r - place + 1;
			} else {
				extra = 0;
			}

			res += q * place + extra;
			place = place * 10;
		}

		return res;

	}

}
