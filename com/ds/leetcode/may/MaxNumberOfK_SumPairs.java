package com.ds.leetcode.may;

import java.util.Arrays;

/*
 * You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.
 */
//leetcode 1679. Max Number of K-Sum Pairs
public class MaxNumberOfK_SumPairs {

	public int maxOperations(int[] nums, int k) {

		Arrays.sort(nums);

		int c = 0;

		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			int sum = nums[i] + nums[j];
			if (sum > k) {
				j--;
			} else if (sum < k) {
				i++;
			} else {
				i++;
				j--;
				c++;
			}
		}

		return c;

	}

}
