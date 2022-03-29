package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array that contains only 0s and 1s.
2. You have to find the count of subarrays with equal number of 0s and 1s.
 */
public class CountOfSubarraysWithEqualNumberOfZeroesAndOnes {

	// O(n) time and space
	public static int solution(int[] arr) {

		int ans = 0;
		int sum = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(sum, 1);

		for (int x : arr) {
			sum += (x == 0 ? -1 : 1);

			if (map.containsKey(sum)) {
				ans += map.get(sum);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			} else {
				map.put(sum, 1);
			}
		}

		return ans;
	}

}
