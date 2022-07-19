package com.ds.level2.ArrayAndString;

//768. Max Chunks To Make Sorted II

/*
 * You are given an integer array arr.

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. 
After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.
 */

public class MaxChunksToMakeSortedII {

	public int maxChunksToSorted(int[] arr) {

		int minfr[] = new int[arr.length];

		minfr[minfr.length - 1] = arr[arr.length - 1];

		for (int i = arr.length - 2; i >= 0; i--) {
			minfr[i] = Math.min(arr[i], minfr[i + 1]);
		}

		int res = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length - 1; i++) {
			max = Math.max(max, arr[i]);
			if (max <= minfr[i + 1]) {
				res++;
			}
		}

		return res + 1;

	}

}
