package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Given an array arr[] of N elements containing first N positive integers.
 *  You have to sort the integers in ascending order by the following operation.
 *   Operation is to pick an integer and place it at end or at start. Every such operation
 *    increases cost by one. The task is to sort the array in the minimum cost
 */
public class TrickySortingCost {

	public static int sortingCost(int arr[]) {
		// code here

		int max = 0;

		// finding longest consecutive sequence.
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x : arr) {
			if (map.containsKey(x - 1)) {
				map.put(x, map.get(x - 1) + 1);
			} else {
				map.put(x, 1);
			}

			if (map.get(x) > max) {
				max = map.get(x);
			}
		}

		return arr.length - max;

	}

}
