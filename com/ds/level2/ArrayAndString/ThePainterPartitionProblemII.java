package com.ds.level2.ArrayAndString;

//The Painter's Partition Problem-II on gfg

/*
 * Dilpreet wants to paint his dog's home that has n boards with different lengths. The length of ith board
 *  is given by arr[i] where arr[] is an array of n integers. He hired k painters for this work and each
 *   painter takes 1 unit time to paint 1 unit of the board. 

The problem is to find the minimum time to get this job done if all painters start together with the
 constraint that any painter will only paint continuous boards, say boards numbered {2,3,4} or only board
  {1} or nothing but not boards {2,4,5}.


 */

public class ThePainterPartitionProblemII {

	static long minTime(int[] arr, int n, int k) {
		// code here
		long lo = Long.MIN_VALUE;
		long hi = 0;

		for (int val : arr) {
			hi += val;
			lo = Math.max(lo, val);
		}

		while (lo < hi) {

			long mid = (lo + hi) / 2;

			int painterReq = 1;
			int currPainterWork = 0;

			for (int val : arr) {

				if (currPainterWork + val <= mid) {
					currPainterWork += val;
				} else {
					currPainterWork = val;
					painterReq++;
				}

			}

			if (painterReq > k) {
				lo = mid + 1;
			} else {
				hi = mid;
			}

		}

		return lo;

	}

}
