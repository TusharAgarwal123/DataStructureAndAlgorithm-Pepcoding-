package com.ds.level2.ArrayAndString;

//795. Number of Subarrays with Bounded Maximum

/*
 * Given an integer array nums and two integers left and right, return the number of contiguous non-empty
 *  subarrays such that the value of the maximum array element in that subarray is in the range [left, right].

The test cases are generated so that the answer will fit in a 32-bit integer.
 */

public class NumberOfSubarraysWithBoundedMaximum {

	public int numSubarrayBoundedMax(int[] nums, int left, int right) {

		int s = -1;
		int e = -1;

		int res = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= left && nums[i] <= right) { // in range
				e = i;
			} else if (nums[i] > right) {
				e = s = i;
			} else { // smaller than left
				// do nothing in that case.
			}

			res += (e - s);
		}

		return res;

	}

}
