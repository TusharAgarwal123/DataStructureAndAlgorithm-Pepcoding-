package com.ds.level2.hashmap;

import java.util.HashSet;

public class CheckArtihmeticProgression {

	/*
	 * Given an array of N integers. Write a program to check whether an arithmetic
	 * progression can be formed using all the given elements.
	 */

	boolean checkIsAP(int arr[], int n) {
		// code here

		HashSet<Integer> set = new HashSet<>();
		int min = Integer.MAX_VALUE;
		int smin = Integer.MAX_VALUE;

		for (int x : arr) {
			set.add(x);

			if (x < min) {
				smin = min;
				min = x;
			} else if (x < smin) {
				smin = x;
			}
		}

		int d = smin - min;

		for (int i = 1; i <= n; i++) {
			int term = min + (i - 1) * d;
			if (!set.contains(term)) {
				return false;
			}
		}

		return true;

	}

}
