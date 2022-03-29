package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Given an array A[] and positive integer K, the task is to count total number of pairs in the array whose sum is divisible by K.
 */
public class CountPairsWhoseSumIsdivisibleByK {

	public static int countKdivPairs(int arr[], int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int x : arr) {
			int rem = x % k;
			if (rem < 0) {
				rem += k;
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		int ans = 0;

		int i = 1;
		int j = k - 1;

		while (i < j) {
			int x1 = (map.get(i) != null ? map.get(i) : 0);
			int x2 = (map.get(j) != null ? map.get(j) : 0);

			ans += (x1 * x2);
			i++;
			j--;

		}

		// for when k is even.
		if (i == j) {
			int x1 = (map.get(i) != null ? map.get(i) : 0);
			int val = (x1 * (x1 - 1)) / 2;
			ans += val;

		}

		int x1 = (map.get(0) != null ? map.get(0) : 0);
		int val = (x1 * (x1 - 1)) / 2;
		ans += val;

		return ans;
	}

}
