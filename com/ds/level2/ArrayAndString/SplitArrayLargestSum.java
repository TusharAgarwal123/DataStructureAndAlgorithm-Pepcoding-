package com.ds.level2.ArrayAndString;

//410. Split Array Largest Sum

/*
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array
 *  into m non-empty continuous subarrays.

Write an algorithm to minimize the largest sum among these m subarrays.


 */

public class SplitArrayLargestSum {

	public int splitArray(int[] nums, int m) {

		int lo = Integer.MIN_VALUE;
		int hi = 0;

		for (int x : nums) {
			hi += x;
			lo = Math.max(lo, x);
		}

		while (lo < hi) {

			int mid = lo + (hi - lo) / 2;

			int limit = mid;

			int countParts = 1;
			int currPartSum = 0;

			for (int num : nums) {
				if (currPartSum + num <= limit) {
					currPartSum += num;
				} else {
					currPartSum = num;
					countParts++;
				}
			}

			if (countParts > m) {
				lo = mid + 1;
			} else {
				hi = mid;
			}

		}

		return lo;

	}

}
