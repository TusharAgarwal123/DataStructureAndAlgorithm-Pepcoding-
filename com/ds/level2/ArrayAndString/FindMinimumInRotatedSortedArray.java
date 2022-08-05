package com.ds.level2.ArrayAndString;

//153. Find Minimum in Rotated Sorted Array

public class FindMinimumInRotatedSortedArray {

	// O(logn)
	public int findMin(int[] nums) {

		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return nums[hi];

	}

}
