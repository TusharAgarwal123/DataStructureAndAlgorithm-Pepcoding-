package com.ds.level2.ArrayAndString;

//1283. Find the Smallest Divisor Given a Threshold

/*
 * Given an array of integers nums and an integer threshold, we will choose a positive integer divisor,
 *  divide all the array by it, and sum the division's result. Find the smallest divisor such that the
 *   result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element.
 (For example: 7/3 = 3 and 10/2 = 5).

The test cases are generated so that there will be an answer.
 */

public class FindTheSmallestDivisorGivenAThreshold {

	public int smallestDivisor(int[] nums, int threshold) {

		int lo = 1;
		int hi = Integer.MIN_VALUE;

		for (int val : nums) {
			if (val > hi) {
				hi = val;
			}
		}

		while (lo < hi) {
			int mid = (lo + hi) / 2;

			int sum = 0;
			for (int val : nums) {
				int quo = (val + mid - 1) / mid; // to find the ceil we have added (mid-1)
				sum += quo;
			}

			if (sum > threshold) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return lo; // we can return the hi also.

	}

}
