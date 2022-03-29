package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array(arr) of integers and a number K.
2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
 */
public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {

	public static void solution(int[] arr, int k) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int x : arr) {
			int rem = x % k;
			if (rem < 0) {
				rem += k;
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		int i = 1;
		int j = k - 1;

		while (i < j) {

			if (map.get(i) != map.get(j)) {
				System.out.println(false);
				return;
			}

			i++;
			j--;

		}

		if (i == j) {
			if (map.get(i) != null && map.get(i) % 2 != 0) {
				System.out.println(false);
				return;
			}
		}

		if (map.get(0) != null && map.get(0) % 2 != 0) {
			System.out.println(false);
			return;
		}

		System.out.println(true);

	}

	// another approach
	public static void solution2(int[] arr, int k) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int x : arr) {
			int rem = x % k;
			if (rem < 0) {
				rem += k;
			}
			map.put(rem, map.getOrDefault(rem, 0) + 1);
		}

		for (int x : arr) {
			int rem = x % k;
			if (rem < 0) {
				rem += k;
			}

			if (2 * rem == k) {
				if (map.get(rem) % 2 != 0) {
					System.out.println(false);
					return;
				}
			} else if (rem == 0) {
				if (map.get(rem) % 2 != 0) {
					System.out.println(false);
					return;
				}
			} else {
				if (map.get(rem) != map.get(k - rem)) {
					System.out.println(false);
					return;
				}
			}

		}

		System.out.println(true);

	}

}
