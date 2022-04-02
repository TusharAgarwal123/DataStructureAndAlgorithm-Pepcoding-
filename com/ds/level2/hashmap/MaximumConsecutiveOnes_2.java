package com.ds.level2.hashmap;

/*
 * 1. You are given an array(arr) which contains only 0's and 1's and a number K.
2. You have to find the maximum number of consecutive 1's in the given array if you 
can flip at most K zeroes.
 */
//leetcode 1004.
public class MaximumConsecutiveOnes_2 {

	public int longestOnes(int[] nums, int k) {

		int i = 0;
		int j = -1;

		int cz = 0;
		int ans = 0;

		while (i < nums.length) {
			if (nums[i] == 0) {
				cz++;
			}

			if (cz <= k) {
				ans = Math.max(ans, (i - j));
			} else {
				while (true) {

					if (nums[j + 1] == 0) {
						j++;
						cz--;
						break;
					}
					j++;

				}
			}

			i++;
		}

		return ans;
	}

}
