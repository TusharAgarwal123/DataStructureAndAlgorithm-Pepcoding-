package com.ds.level1.sorting;

import java.util.Arrays;

public class TargetSumPair {

	/*
	 * you have given an array and target,you have to print all the pairs whose sum
	 * will be equal to target.in pair always (a<b).
	 */

	public static void main(String[] args) {

		int ar[] = { 5, 4, 7, 2, 6, 3, 8, 1 };
		int k = 9;
		Arrays.sort(ar);

		int i = 0;
		int j = ar.length - 1;

		while (i < j) {
			if (ar[i] + ar[j] > k) {
				j--;
			} else if (ar[i] + ar[j] < k) {
				i++;
			} else {
				System.out.println(ar[i] + "," + ar[j]);
				i++;
				j--;
			}
		}

	}

}
