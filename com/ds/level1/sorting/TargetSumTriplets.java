package com.ds.level1.sorting;

import java.util.Arrays;

/*
 * you have given an array and target,you have to print all the triplets whose sum
 * will be equal to target.
 */

public class TargetSumTriplets {

	public static void main(String[] args) {

		int ar[] = { 5, 4, 7, 2, 6, 3, 8, 1 };
		int tar = 9;
		Arrays.sort(ar);

		for (int i = 0; i < ar.length; i++) {
			int ntar = tar - ar[i];

			int j = i + 1;
			int k = ar.length - 1;

			while (j < k) {
				if (ar[j] + ar[k] > ntar) {
					k--;
				} else if (ar[j] + ar[k] < ntar) {
					j++;
				} else {
					System.out.println(ar[i] + "," + ar[j] + "," + ar[k]);
					j++;
					k--;
				}
			}

		}

	}

}
