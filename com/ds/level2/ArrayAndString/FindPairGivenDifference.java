package com.ds.level2.ArrayAndString;

import java.util.Arrays;

//Find Pair Given Difference  on gfg.

/*
 * Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair
 *  of elements in the array whose difference is N.
 */

public class FindPairGivenDifference {

	public boolean findPair(int ar[], int size, int n) {
		// code here.

		Arrays.sort(ar);

		int j = 0;
		int i = 1;

		while (i < size) {
			if (ar[i] - ar[j] > n) {
				j++;

				if (j == i) {
					i++;
				}
			} else if (ar[i] - ar[j] < n) {
				i++;
			} else {
				return true;
			}
		}

		return false;

	}

}
