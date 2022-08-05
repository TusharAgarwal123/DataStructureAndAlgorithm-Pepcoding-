package com.ds.level2.ArrayAndString;

//First negative integer in every window of size k on gfg

/*
 * Given an array A[] of size N and a positive integer K, find the first negative integer for each and
 *  every window(contiguous subarray) of size K.


 */

public class FirstNegativeIntegerInEveryWindowOfSizeK {

	public long[] printFirstNegativeInteger(long A[], int N, int K) {

		long[] ans = new long[N - K + 1];
		int j = 0;
		for (int i = 0; i <= N - K; i++) {
			if (j < i) {
				j = i;
			}

			while (j < i + K - 1 && A[j] >= 0) {
				j++;
			}

			if (A[j] < 0) {
				ans[i] = A[j];
			}
		}

		return ans;

	}

}
