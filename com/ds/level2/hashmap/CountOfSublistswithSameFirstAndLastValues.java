package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Given a list of integers nums, return the number of sublists where the first
 *  element and the last element have the same value.


 */
public class CountOfSublistswithSameFirstAndLastValues {

	public int solve(int[] nums) {

		int c = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int x : nums) {
			if (map.containsKey(x)) {
				c++;
				int val = map.get(x);
				map.put(x, val + 1);
				c += val;
			} else {
				c++;
				map.put(x, 1);
			}
		}

		return c;

	}

}
