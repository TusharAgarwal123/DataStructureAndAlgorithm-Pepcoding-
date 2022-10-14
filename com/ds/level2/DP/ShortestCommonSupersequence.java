package com.ds.level2.DP;

//Shortest Common Supersequence, on gfg

/*
 * Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which
 *  has both, X and Y as its sub-sequences.
Note: X and Y can have both uppercase and lowercase letters.
 */

public class ShortestCommonSupersequence {

	public static int shortestCommonSupersequence(String X, String Y, int m, int n) {
		// Your code here
		int[][] lcs = new int[m + 1][n + 1];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (X.charAt(i) == Y.charAt(j)) {
					lcs[i][j] = 1 + lcs[i + 1][j + 1];
				} else {
					lcs[i][j] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
				}
			}
		}

		return m + n - lcs[0][0];
	}

}
