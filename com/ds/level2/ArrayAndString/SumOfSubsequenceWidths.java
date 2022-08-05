package com.ds.level2.ArrayAndString;

import java.util.Arrays;

//891. Sum of Subsequence Widths

/*
 * The width of a sequence is the difference between the maximum and minimum elements in the sequence.

Given an array of integers nums, return the sum of the widths of all the non-empty subsequences of nums.
 Since the answer may be very large, return it modulo 109 + 7.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without
 changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array
  [0,3,1,6,2,2,7].
 */

public class SumOfSubsequenceWidths {

	long MOD = 1000000007L;

	public int sumSubseqWidths(int[] nums) {

		Arrays.sort(nums);

		long ans = 0;
		long p = 1; // 2^0

		for (int i = 0; i < nums.length; i++) {
			ans = (ans + p * nums[i] - p * nums[nums.length - 1 - i]) % MOD;
			p = (p * 2) % MOD;
		}

		return (int) ans;

	}

}
