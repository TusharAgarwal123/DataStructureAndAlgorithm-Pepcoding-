package com.ds.level2.ArrayAndString;

import java.util.Arrays;

//719. Find K-th Smallest Pair Distance

/*
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i]
 and nums[j] where 0 <= i < j < nums.length.

 
 */

public class FindK_thSmallestPairDistance {

	public int smallestDistancePair(int[] nums, int k) {

		Arrays.sort(nums);

		int lo = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			lo = Math.min(lo, nums[i + 1] - nums[i]);
		}

		int hi = nums[nums.length - 1] - nums[0];

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			int count = 0;
			int j = 0;
			for (int i = 0; i < nums.length; i++) {
				while (j < nums.length && nums[j] - nums[i] <= mid) {
					j++;
				}

				count += (j - i - 1);
			}

			if (count < k) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return lo;

	}

}
