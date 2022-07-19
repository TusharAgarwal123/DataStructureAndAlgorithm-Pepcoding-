package com.ds.level2.ArrayAndString;

//977. Squares of a Sorted Array

/*
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each 
 * number sorted in non-decreasing order.
 */

public class SquaresOfASortedArray {

	public int[] sortedSquares(int[] nums) {

		int ans[] = new int[nums.length];

		int i = 0;
		int j = nums.length - 1;

		int n = nums.length - 1;

		while (n >= 0) {
			if (Math.abs(nums[i]) > Math.abs(nums[j])) {
				ans[n] = nums[i] * nums[i];
				i++;
			} else {
				ans[n] = nums[j] * nums[j];
				j--;
			}
			n--;
		}

		return ans;

	}

}
