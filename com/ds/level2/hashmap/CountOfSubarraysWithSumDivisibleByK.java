package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array of integers(arr) and a number K.
2. You have to find the count of subarrays whose sum is divisible by K.
 */
public class CountOfSubarraysWithSumDivisibleByK {
	public static int solution(int[] arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		int sum = 0;

		map.put(sum, 1);

		for (int x : arr) {
			sum += x;

			int rem = sum % k;

			if (rem < 0) {
				rem += k;
			}

			if (map.containsKey(rem)) {
				ans += map.get(rem);
				map.put(rem, map.getOrDefault(rem, 0) + 1);
			} else {
				map.put(rem, 1);
			}
		}

		return ans;
	}

}
