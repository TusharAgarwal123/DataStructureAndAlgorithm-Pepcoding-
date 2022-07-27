package com.ds.level2.ArrayAndString;

//152. Maximum Product Subarray

/*
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest
 *  product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.


 */

public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {

		int res = Integer.MIN_VALUE;

		int prod = 1;

		// prefix subarray product.
		for (int i = 0; i < nums.length; i++) {
			prod = prod * nums[i];

			if (prod > res) {
				res = prod;
			}

			if (prod == 0) { // when product become 0 we are breaking .
				prod = 1;
			}
		}

		prod = 1;

		// suffix subarray product.
		for (int i = nums.length - 1; i >= 0; i--) {
			prod = prod * nums[i];
			if (prod > res) {
				res = prod;
			}

			if (prod == 0) { // when product become 0 we are breaking .
				prod = 1;
			}
		}

		return res;

	}

}
