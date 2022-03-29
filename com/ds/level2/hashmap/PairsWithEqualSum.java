package com.ds.level2.hashmap;

import java.util.HashSet;

/*
 * 1. You are given an array(arr) of distinct integers.
2. You have to find if there are two pairs(A, B) and (C, D) present in the given array which
 satisfies the condition A+B = C+D.
 */
public class PairsWithEqualSum {

	public static boolean solution(int[] arr) {
		// write your code here

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (set.contains(sum)) {
					return true;
				} else {
					set.add(sum);
				}
			}
		}

		return false;
	}

}
