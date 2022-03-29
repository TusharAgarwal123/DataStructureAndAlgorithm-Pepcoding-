package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array of integers(arr) and a number K.
2. You have to find length of the longest subarray whose sum is divisible by K.
 */
public class LongestSubarrayWithSumDivisibleByK {

	public static int solution(int[] arr, int k) {
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxValue = Integer.MIN_VALUE;

		map.put(sum, -1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			int rem = sum % k;
			if (rem < 0) {
				rem += k;
			}

			if (map.containsKey(rem)) {
				int idx = map.get(rem);
				int len = i - idx;
				maxValue = Math.max(maxValue, len);

			} else {
				map.put(rem, i);
			}
		}

		return maxValue;
	}

}
