package com.ds.level2.ArrayAndString;

//668. Kth Smallest Number in Multiplication Table

/*
 * Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer
 *  matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.


 */

public class KthSmallestNumberInMultiplicationTable {

	public int findKthNumber(int m, int n, int k) {

		int lo = 1;
		int hi = m * n;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			int count = 0;

			int j = n;

			for (int i = 1; i <= m; i++) {
				while (j >= 1 && i * j > mid) {
					j--;
				}

				count += j;
			}

			if (count < k) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return lo;

	}

}
