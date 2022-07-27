package com.ds.level2.ArrayAndString;

//53. Maximum Subarray

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the
 *  largest sum and return its sum.

A subarray is a contiguous part of an array.


 */

public class KadanesAlgorithm {

	public int maxSubArray(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}

		int max = Integer.MIN_VALUE;

		int sum = 0;

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			max = Math.max(max, sum);

			if (sum < 0) {
				sum = 0;
			}

		}

		return max;

	}

}
