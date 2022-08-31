package com.ds.level2.ArrayAndString;

//Wave Array on gfg

/*
 * Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5]
.....

If there are multiple solutions, find the lexicographically smallest one.
 */

public class WaveArray {

	public static void convertToWave(int n, int[] a) {
		// code here
		for (int i = 0; i < n; i += 2) {
			if (i < n - 1) {
				int t = a[i + 1];
				a[i + 1] = a[i];
				a[i] = t;
			}
		}

	}

}
