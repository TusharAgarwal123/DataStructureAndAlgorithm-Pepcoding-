package com.ds.level2.hashmap;

import java.util.HashSet;

/*
 * 1. You are given an array(arr) of integers. Values may be duplicated.
2. You have to find the length of the largest subarray with contiguous elements.

Note -> The contiguous elements can be in any order(not necessarily in increasing order).
 */
public class LargestSubarrayWithContiguousElements {

	public static int solution(int[] arr) {
		// write your code here

		int ans = 0;

		for (int i = 0; i < arr.length; i++) {

			int min = arr[i];
			int max = arr[i];
			HashSet<Integer> set = new HashSet<>();
			set.add(arr[i]);

			for (int j = i + 1; j < arr.length; j++) {

				if (set.contains(arr[j])) {
					break;
				}

				set.add(arr[j]);

				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);

				if (max - min == j - i) {
					ans = Math.max(ans, (j - i + 1));
				}

			}

		}

		return ans;
	}

}
