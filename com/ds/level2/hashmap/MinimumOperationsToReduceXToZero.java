package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.Map;

//leetcode 1658. Minimum Operations to Reduce X to Zero

/*
 * You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 */

public class MinimumOperationsToReduceXToZero {

	public int minOperations(int[] nums, int x) {

		int target = -x;

		for (int num : nums)
			target += num;

		if (target == 0)
			return nums.length;

		if (target < 0)
			return -1;

		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0;

		int ans = 0;

		map.put(sum, -1);

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			if (map.containsKey(sum - target)) {
				int len = i - map.get(sum - target);
				ans = Math.max(ans, len);
			}

			map.put(sum, i);

		}

		return ans > 0 ? nums.length - ans : -1;

	}

}
