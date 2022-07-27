package com.ds.level2.ArrayAndString;

//915. Partition Array into Disjoint Intervals

/*
 * Given an integer array nums, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.


 */

public class PartitionArrayIntoDisjointIntervals {

	// optimized O(n) time and O(1) space.
	public int partitionDisjoint(int[] nums) {

		int pi = 0;
		int mtp = nums[0]; // maximum till partition
		int mts = nums[0]; // maximum till scan

		for (int i = 1; i < nums.length; i++) {
			mts = Math.max(nums[i], mts);

			if (nums[i] < mtp) {
				pi = i;
				mtp = mts;
			}
		}

		return pi + 1;

	}

	// O(n) time and O(n) space.
	public int partitionDisjoint2(int[] nums) {

		int left[] = new int[nums.length]; // store the maximum till each index from left side.
		int right[] = new int[nums.length]; // store the minimum till each index from right side.

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(nums[i], left[i - 1]);
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			if (i == nums.length - 1) {
				right[i] = nums[i];
			} else {
				right[i] = Math.min(nums[i], right[i + 1]);
			}
		}

		int ans = -1;

		for (int i = 0; i < nums.length - 1; i++) {

			if (left[i] <= right[i + 1]) {
				ans = i + 1;
				break;
			}
		}

		return ans;

	}

}
