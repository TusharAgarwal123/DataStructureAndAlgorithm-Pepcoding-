package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array(arr) of integers.
2. You have to find the count of all subarrays with sum 0.
 */
public interface CountOfAllSubarraysWithZeroSum {

	public static int solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		map.put(0, 1);

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			} else {
				map.put(sum, 1);
			}

		}

		return count;
	}

}
