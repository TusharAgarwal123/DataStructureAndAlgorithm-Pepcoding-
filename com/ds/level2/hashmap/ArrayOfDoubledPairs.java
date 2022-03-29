package com.ds.level2.hashmap;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.
 */
// description of question is very complex we just need to check weather double of half of the array
//element if present or not.
public class ArrayOfDoubledPairs {

	public boolean canReorderDoubled(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int val : arr) {
			if (val != 0) {
				map.put(val, map.getOrDefault(val, 0) + 1);
			}
		}

		Arrays.sort(arr);

		for (int x : arr) {
			if (x != 0 && map.containsKey(x) && map.containsKey(2 * x)) {
				if (map.get(x) > 1) {
					map.put(x, map.get(x) - 1);
				} else {
					map.remove(x);
				}

				if (map.get(2 * x) > 1) {
					map.put(2 * x, map.get(2 * x) - 1);
				} else {
					map.remove(2 * x);
				}
			}
		}

		if (map.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

}
