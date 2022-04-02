package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a]
 * , nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
 */

//leetcode 18. 4Sum.
public class QuadrupletSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {

		HashSet<List<Integer>> set = new HashSet<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {

				int left = j + 1;
				int right = nums.length - 1;

				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						List<Integer> list = new ArrayList<>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);

						set.add(list);
						left++;
						right--;

					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}

			}
		}

		List<List<Integer>> ans = new ArrayList<>();
		for (List<Integer> ll : set) {
			ans.add(ll);
		}

		return ans;

	}

}
