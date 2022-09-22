package com.ds.level2.DP;

//Largest Sum Subarray of Size at least K on gfg.

/*
 * Given an array and a number k, find the largest sum of the subarray containing at least k numbers.
 *  It may be assumed that the size of array is at-least k.
 */

public class LargestSumSubarrayOfSizeAtLeastK {

	public long maxSumWithK(long a[], long n, long k) {

		long[] res = new long[(int) n];
		long csum = a[0];

		res[0] = csum;

		for (int i = 1; i < n; i++) {
			if (csum > 0) {
				csum += a[i];
			} else {
				csum = a[i];
			}

			res[i] = csum;
		}

		long[] win = new long[(int) n - (int) k + 1];
		for (int i = 0; i < k; i++) {
			win[0] = win[0] + a[i];
		}

		for (int i = 1; i < win.length; i++) {
			win[i] = win[i - 1] - a[i - 1] + a[i + (int) k - 1];
		}

		long ans = 0 + win[0];

		for (int i = 0; i < win.length - 1; i++) {
			ans = Math.max(ans, Math.max(win[i + 1], res[i] + win[i + 1]));
		}

		return ans;

	}

}
