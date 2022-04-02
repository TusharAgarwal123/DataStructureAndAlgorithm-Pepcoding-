package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given a number N and two sorted matrices(A and B) of N*N dimensions.
2. You are also given a number X.
3. You have to find the count of all valid pairs from matrices whose sum is equal to X.
4. A pair is called valid if one element of the pair is selected from A and the second element is selected from B.
 */
public class PairsWithGivenSumInTwoSortedMatrices {

	// This approach will work for both cases that (contains duplicate and not
	// contains duplicate)
	// space O(n)
	// time O(n^2)
	public static int solve(int[][] num1, int[][] num2, int k) {
		// write your code here

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int x[] : num1) {
			for (int y : x) {
				map.put(y, map.getOrDefault(y, 0) + 1);
			}
		}

		int c = 0;

		for (int x[] : num2) {
			for (int y : x) {
				int diff = k - y;
				if (map.containsKey(diff)) {
					c += map.get(diff);
				}
			}
		}

		return c;
	}

	// This approach will work only when array contains all unique elements.
	// space O(1)
	// time O(n^2)
	public static int solve2(int[][] num1, int[][] num2, int k) {

		int size = num1.length * num1[0].length;

		int left = 0;
		int right = size - 1;

		int ans = 0;

		while (left < size && right >= 0) {

			int r1 = left / (num1[0].length);
			int c1 = left % (num1[0].length);

			int r2 = right / (num2[0].length);
			int c2 = right % (num2[0].length);

			if (num1[r1][c1] + num2[r2][c2] == k) {
				ans++;
				left++;
				right--;
			} else if (num1[r1][c1] + num2[r2][c2] < k) {
				left++;
			} else {
				right--;
			}

		}

		return ans;

	}

}
