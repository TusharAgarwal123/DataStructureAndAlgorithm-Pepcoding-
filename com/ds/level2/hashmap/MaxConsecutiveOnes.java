package com.ds.level2.hashmap;

/*
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 */
public class MaxConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {

		int tl = 0;
		int ml = 0;

		for (int x : nums) {
			if (x == 1) {
				tl++;
			} else {
				ml = Math.max(ml, tl);
				tl = 0;
			}
		}

		ml = Math.max(ml, tl);

		return ml;
	}

}
