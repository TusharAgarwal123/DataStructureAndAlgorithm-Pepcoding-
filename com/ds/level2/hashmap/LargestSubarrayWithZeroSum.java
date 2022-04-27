package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array(arr) of integers.
2. You have to find the length of the largest subarray with sum 0.
 */
public class LargestSubarrayWithZeroSum {

	public static int solution(int[] arr) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		map.put(0, -1);

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (map.containsKey(sum)) {
				int idx = map.get(sum);
				ans = Math.max(ans, (i - idx));
			} else {
				map.put(sum, i);
			}

		}

		return ans;
	}

}
