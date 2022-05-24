package com.ds.leetcode.may;

/*
 * Given an integer array nums, move all the even 
 * integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.
 */
//905. Sort Array By Parity
public class SortArrayByParity {

	public int[] sortArrayByParity(int[] nums) {

		int i = 0;
		int j = 0;

		while (i < nums.length) {
			if (nums[i] % 2 != 0) {
				i++;
			} else {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j++;
			}
		}

		return nums;

	}

}
