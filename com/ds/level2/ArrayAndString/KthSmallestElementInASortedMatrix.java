package com.ds.level2.ArrayAndString;

//378. Kth Smallest Element in a Sorted Matrix

/*
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth
 *  smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).
 */

public class KthSmallestElementInASortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {

		int lo = matrix[0][0];
		int hi = matrix[matrix.length - 1][matrix[0].length - 1];

		int reqd = k;

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			int actual = 0;

			int j = matrix[0].length - 1;

			for (int i = 0; i < matrix.length; i++) {
				while (j >= 0 && matrix[i][j] > mid) {
					j--;
				}

				actual += (j + 1);
			}

			if (actual < reqd) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}

		return lo;

	}

}
