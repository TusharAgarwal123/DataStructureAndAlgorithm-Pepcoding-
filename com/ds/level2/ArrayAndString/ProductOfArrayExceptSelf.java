package com.ds.level2.ArrayAndString;

//238. Product of Array Except Self

/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
 *  elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


 */

public class ProductOfArrayExceptSelf {

	public int[] productExceptSelf(int[] nums) {

		int left[] = new int[nums.length];

		left[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		int right = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			right = right * nums[i + 1];
			left[i] = left[i] * right;
		}

		return left;

	}

}
