package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum equals k.
 */
public class CountOfSubarraysHavingSumEqualsToK {

	public static int solution(int[] arr, int target) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		int sum = 0;

		map.put(sum, 1);

		for (int x : arr) {
			sum += x;

			if (map.containsKey(sum - target)) {
				ans += map.get(sum - target);
			}

			if (map.containsKey(sum)) {
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			} else {
				map.put(sum, 1);
			}
		}

		return ans;
	}

}
