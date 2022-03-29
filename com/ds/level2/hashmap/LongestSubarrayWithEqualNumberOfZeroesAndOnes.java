package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array that contains only 0s and 1s.
2. You have to find length of the longest subarray with equal number of 0s and 1s.
 */
public class LongestSubarrayWithEqualNumberOfZeroesAndOnes {
	public static int solution(int[] arr) {
		// write your code here

		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxValue = Integer.MIN_VALUE;

		map.put(sum, -1);

		for (int i = 0; i < arr.length; i++) {
			sum += (arr[i] == 0 ? -1 : 1);

			if (map.containsKey(sum)) {
				int idx = map.get(sum);
				int len = i - idx;
				maxValue = Math.max(maxValue, len);

			} else {
				map.put(sum, i);
			}
		}

		return maxValue;
	}

}
