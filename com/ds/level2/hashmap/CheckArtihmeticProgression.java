package com.ds.level2.hashmap;

import java.util.HashSet;

public class CheckArtihmeticProgression {

	/*
	 * Given an array of N integers. Write a program to check whether an arithmetic
	 * progression can be formed using all the given elements.
	 */

	boolean checkIsAP(int arr[], int n) {
		// code here

		if (arr.length == 1) {
			return true;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(max, arr[i]);
			set.add(arr[i]);
		}
		int diff = (max - min) / (arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == min || arr[i] == max) {
			} else {
				if (!set.contains(arr[i] - diff) || !set.contains(arr[i] + diff)) {
					return false;
				}
			}
		}

		return true;

	}

}
