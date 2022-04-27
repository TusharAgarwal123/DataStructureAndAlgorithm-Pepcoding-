package com.ds.level2.bitManipulation;

/*
 * Given an integer n, return an array ans of length n + 1 such
 *  that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

//338. Counting Bits
public class CountingBits {

	public int[] countBits(int n) {

		int ans[] = new int[n + 1];
		ans[0] = 0;

		for (int i = 1; i <= n; i++) {

			ans[i] = count(i);
		}

		return ans;

	}

	public int count(int n) {

		int c = 0;
		while (n > 0) {
			int rb = (n & -n);
			c++;
			n = n - rb;
		}

		return c;

	}

}
