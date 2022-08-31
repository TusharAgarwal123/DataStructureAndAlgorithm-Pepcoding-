package com.ds.level2.ArrayAndString;

//154. Find Minimum in Rotated Sorted Array II

public class FindMinimumInRotatedSortedArrayII {

	public int findMin(int[] nums) {

		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			if (nums[hi] > nums[mid]) {
				hi = mid;
			} else if (nums[hi] < nums[mid]) {
				lo = mid + 1;
			} else {
				hi--;
			}
		}

		return nums[lo];

	}

}
