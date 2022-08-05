package com.ds.level2.ArrayAndString;

//628. Maximum Product of Three Numbers

/*
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.


 */

public class MaximumProductOfThreeNumbers {

	public int maximumProduct(int[] nums) {

		int min1 = Integer.MAX_VALUE; // first smallest
		int min2 = Integer.MAX_VALUE; // second smallest

		int max1 = Integer.MIN_VALUE; // first largest
		int max2 = Integer.MIN_VALUE; // second largest
		int max3 = Integer.MIN_VALUE; // third largest

		for (int num : nums) {

			if (num <= min1) {
				min2 = min1;
				min1 = num;
			} else if (num <= min2) {
				min2 = num;
			}

			if (num >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if (num >= max2) {
				max3 = max2;
				max2 = num;
			} else if (num >= max3) {
				max3 = num;
			}

		}

		return Math.max(min1 * min2 * max1, max1 * max2 * max3);

	}

}
