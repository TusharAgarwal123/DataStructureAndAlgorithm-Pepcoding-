package com.ds.level2.Graph;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of n distinct elements. Find the minimum number of swaps required to sort the array
 *  in strictly increasing order.
 */

public class MinimumSwapsToSort {

	public int minSwaps(int nums[]) {
		// Code here

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		Arrays.sort(nums);

		boolean vis[] = new boolean[nums.length];
		int ans = 0;

		for (int i = 0; i < nums.length; i++) {
			if (vis[i] == true || map.get(nums[i]) == i) {
				continue;
			}

			vis[i] = true;

			int j = i;
			int cSize = 0; // cycle size.
			do {
				cSize++;
				j = map.get(nums[j]);
				vis[j] = true;
			} while (j != i);

			ans += (cSize - 1);
		}

		return ans;
	}

}
