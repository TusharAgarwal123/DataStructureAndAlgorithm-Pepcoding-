package com.ds.level1.DP;

import java.util.Arrays;

//300. Longest Increasing Subsequence

/*
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without
 changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array
  [0,3,1,6,2,2,7].
 */

public class LongestIncreasingSubsequence {

	// O(nlogn) optimized approach.
	public int lengthOfLIS(int[] nums) {

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

		return len;

	}

	// O(n^2), using DP.
	public int lengthOfLIS2(int[] nums) {

		int[] lis = new int[nums.length];
		lis[0] = 1;

		for (int i = 1; i < lis.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, lis[j]);
				}
			}

			lis[i] = max + 1;
		}

		int ans = lis[0];
		for (int i = 1; i < lis.length; i++) {
			if (lis[i] > ans) {
				ans = lis[i];
			}
		}

		return ans;

	}
}
