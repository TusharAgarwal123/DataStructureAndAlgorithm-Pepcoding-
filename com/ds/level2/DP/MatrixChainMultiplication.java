package com.ds.level2.DP;

//Matrix Chain Multiplication

/*
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The
 *  efficient way is the one that involves the least number of multiplications.

The dimensions of the matrices are given in an array arr[] of size N (such that N = number of matrices + 1)
 where the ith matrix has the dimensions (arr[i-1] x arr[i]).


 */

public class MatrixChainMultiplication {

	static int matrixMultiplication(int N, int ar[]) {
		// code here
		int[][] dp = new int[N - 1][N - 1];

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 0;
				} else if (g == 1) {
					dp[i][j] = ar[i] * ar[j] * ar[j + 1];
				} else {

					int min = Integer.MAX_VALUE;
					for (int k1 = 1, k2 = g; k1 <= g; k1++, k2--) {
						int left = dp[i][j - k2];
						int right = dp[i + k1][j];
						int multc = ar[i] * ar[j + 1] * ar[i + k1];

						min = Math.min(min, left + right + multc);
					}
					dp[i][j] = min;
				}

			}
		}

		return dp[0][N - 2];

	}

}
