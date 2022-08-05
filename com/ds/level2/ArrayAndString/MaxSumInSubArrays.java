package com.ds.level2.ArrayAndString;

//Max sum in sub-arrays on gfg

/*
 * Given an array, find maximum sum of smallest and second smallest elements chosen from all
 *  possible sub-arrays. More formally, if we write all (nC2) sub-arrays of array of size >=2 and
 *   find the sum of smallest and second smallest, then our answer will be maximum sum among them.
 */

public class MaxSumInSubArrays {

	public static long pairWithMaxSum(long arr[], long N) {
		// Your code goes here

		long ans = 0;

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] + arr[i + 1] > ans) {
				ans = arr[i] + arr[i + 1];
			}
		}

		return ans;

	}

}
