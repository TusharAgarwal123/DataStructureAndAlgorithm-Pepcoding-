package com.ds.leetcode.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Given a collection of numbers, nums, that might contain duplicates,
 *  return all possible unique permutations in any order.
 */
//47. Permutations II
public class PermutationsII {

	List<List<Integer>> ans = new ArrayList<>();

	public List<List<Integer>> permuteUnique(int[] nums) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x : nums) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		solve(nums, 1, nums.length, map, new ArrayList<Integer>());

		return ans;

	}

	public void solve(int nums[], int cs, int ts, HashMap<Integer, Integer> map, List<Integer> list) {

		if (cs > ts) {
			ans.add(list);
			return;
		}

		for (int x : map.keySet()) {
			if (map.get(x) > 0) {
				list.add(x);
				map.put(x, map.get(x) - 1);
				solve(nums, cs + 1, ts, map, new ArrayList<>(list));
				map.put(x, map.get(x) + 1);
				list.remove(list.size() - 1);
			}
		}

	}

}
