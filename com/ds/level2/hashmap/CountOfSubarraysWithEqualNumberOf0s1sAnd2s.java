package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array that contains only 0s, 1s, and 2s.
2. You have to find the count of subarrays with equal number of 0s, 1s, and 2s.
 */
public class CountOfSubarraysWithEqualNumberOf0s1sAnd2s {

	// O(n) time and space.
	public static int solution(int[] arr) {
		HashMap<String, Integer> map = new HashMap<>();
		int c1 = 0;
		int c2 = 0;
		int c0 = 0;

		int ans = 0;

		String key = "0#0";

		map.put(key, 1);
		for (int x : arr) {
			if (x == 0) {
				c0++;
			} else if (x == 1) {
				c1++;
			} else {
				c2++;
			}

			key = (c1 - c0) + "#" + (c2 - c1);

			if (map.containsKey(key)) {
				int val = map.get(key);
				ans += val;
				map.put(key, val + 1);
			} else {
				map.put(key, 1);
			}

		}

		return ans;
	}

	// if string is giving in place of array.
	public static int solution2(String arr) {
		HashMap<String, Integer> map = new HashMap<>();
		int c1 = 0;
		int c2 = 0;
		int c0 = 0;

		int ans = 0;

		String key = "0#0";

		map.put(key, 1);
		for (char x : arr.toCharArray()) {
			if (x == '0') {
				c0++;
			} else if (x == '1') {
				c1++;
			} else {
				c2++;
			}

			key = (c1 - c0) + "#" + (c2 - c1);

			if (map.containsKey(key)) {
				int val = map.get(key);
				ans += val;
				map.put(key, val + 1);
			} else {
				map.put(key, 1);
			}

		}

		return ans;
	}

}
