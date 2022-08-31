package com.ds.level1.DP;

import java.util.Arrays;

//Minimum number of increasing subsequences

/*
 * Given an array of integers of size N, you have to divide it into the minimum number of “strictly
 *  increasing subsequences” 
For example: let the sequence be {1, 3, 2, 4}, then the answer would be 2. In this case, the first increasing
 sequence would be {1, 3, 4} and the second would be {2}.
 */

public class MinimumNumberOfIncreasingSubsequences {

	// O(nlogn) optimized approach.
	public int increasingSubsequence(int[] nums) {

		int[] tails = new int[nums.length];
		int len = 1; // it is tails length.
		tails[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > tails[len - 1]) {
				len++;
				tails[len - 1] = nums[i];
			} else {
				int idx = Arrays.binarySearch(tails, 0, len - 1, nums[i]); // we can also created our own binary search
																			// function then we need not to handle
																			// negative case.
				if (idx < 0) { // if it come as negative means search value is not present and search
					// value will be on idx position, so we have to substract -1 from position
					// to make it index.
					idx = idx * -1;
					idx = idx - 1;
				}

				tails[idx] = nums[i];
			}
		}

		int ans = nums.length - len;

		return ans + 1;

	}

	// O(n^2)
	public static int increasingSubsequence2(int[] ar) {

		int[] lis = new int[ar.length];
		lis[0] = 1;

		for (int i = 1; i < lis.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (ar[j] < ar[i]) {
					max = Math.max(max, lis[j]);
				}
			}

			lis[i] = max + 1;
		}

		int len = 0;
		for (int x : lis) {
			len = Math.max(len, x);
		}
		int ans = ar.length - len;

		return ans + 1;
	}

}
