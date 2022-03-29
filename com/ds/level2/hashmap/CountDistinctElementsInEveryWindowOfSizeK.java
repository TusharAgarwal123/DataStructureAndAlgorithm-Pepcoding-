package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 1. You are given an array(arr) of integers and a number K.
2. You have to find the count of distinct numbers in all windows of size k.
 */
public class CountDistinctElementsInEveryWindowOfSizeK {

	// O(n)
	public static ArrayList<Integer> solution(int[] arr, int k) {
		// write your code here

		ArrayList<Integer> list = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		list.add(map.size());

		int j = 0;
		for (int i = k; i < arr.length; i++) {
			// acquiring
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

			// releasing
			if (map.get(arr[j]) > 1) {
				map.put(arr[j], map.getOrDefault(arr[j], 0) - 1);
			} else {
				map.remove(arr[j]);
			}

			list.add(map.size());
			j++;

		}

		return list;
	}

}
