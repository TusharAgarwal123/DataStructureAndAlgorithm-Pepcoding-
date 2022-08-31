package com.ds.level2.ArrayAndString;

//33. Search in Rotated Sorted Array

/*
 * There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
 (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1],
  ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become
   [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if
 it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.


 */

public class SearchInRotatedSortedArray {

	public int search(int[] nums, int target) {

		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] < nums[hi]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}

		if (nums[lo] == target) {
			return lo;
		}

		int idx = binarySearch(nums, target, 0, lo - 1);

		if (idx != -1) {
			return idx;
		}

		return binarySearch(nums, target, lo + 1, nums.length - 1);

	}

	public int binarySearch(int[] nums, int tar, int l, int h) {

		while (l <= h) {
			int mid = (l + h) / 2;

			if (nums[mid] == tar) {
				return mid;
			} else if (nums[mid] < tar) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		return -1;

	}

}
