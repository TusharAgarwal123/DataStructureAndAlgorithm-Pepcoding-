package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find length of the longest subarray with equal number of 0s, 1s, and 2s.
 */
public class LongestSubarrayWithEqualNumberOf0s1sAnd2s {

	public static int solution(int[] arr) {
		int maxLength = 0;
		int c0 = 0;
		int c1 = 0;
		int c2 = 0;
		String key = "0#0";

		HashMap<String, Integer> map = new HashMap<>();
		map.put(key, -1);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				c0++;
			} else if (arr[i] == 1) {
				c1++;
			} else {
				c2++;
			}

			key = (c0 - c1) + "#" + (c1 - c2);

			if (map.containsKey(key)) {
				int idx = map.get(key);
				int len = i - idx;
				maxLength = Math.max(maxLength, len);
			} else {
				map.put(key, i);
			}
		}

		return maxLength;
	}

}
