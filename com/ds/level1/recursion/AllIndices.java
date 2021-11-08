package com.ds.level1.recursion;

/*
 * 1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the all indices at which x occurs in array a.
5. Return an array of appropriate size which contains all indices at which x occurs in array a.

 */
public class AllIndices {

	public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
		// write ur code here

		if (idx == arr.length) {
			return new int[fsf];
		}

		int ar[];
		if (arr[idx] == x) {
			ar = allIndices(arr, x, idx + 1, fsf + 1);
			ar[fsf] = idx;
			return ar;
		} else {
			ar = allIndices(arr, x, idx + 1, fsf);
			return ar;
		}

	}
}
