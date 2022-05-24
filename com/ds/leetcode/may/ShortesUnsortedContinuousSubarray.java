package com.ds.leetcode.may;

/*
 * Given an integer array nums, you need to find one continuous
 *  subarray that if you only sort this subarray in ascending order,
 *   then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.


 */

//leetcode581. Shortest Unsorted Continuous Subarray
public class ShortesUnsortedContinuousSubarray {

	public int findUnsortedSubarray(int[] nums) {

		if (nums.length == 1) {
			return 0;
		}

		int max = nums[0];
		int end = -1;
		for (int i = 1; i < nums.length; i++) {
			if (max > nums[i]) {
				end = i;
			} else {
				max = nums[i];
			}
		}

		int start = 0;
		int min = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > min) {
				start = i;
			} else {
				min = nums[i];
			}
		}

		return end - start + 1;

	}

}
