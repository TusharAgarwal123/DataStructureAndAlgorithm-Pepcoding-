package com.ds.level2.DP;

//Optimal binary search tree on gfg.

/*
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where
 *  freq[i] is the number of searches to keys[i]. Construct a binary search tree of all keys such that the
 *   total cost of all the searches is as small as possible.
Let us first define the cost of a BST. The cost of a BST node is level of that node multiplied by its frequency.
 Level of root is 1.


 */

public class OptimalBinarySearchTree {

	static int optimalSearchTree(int keys[], int freq[], int n) {
		int[][] dp = new int[keys.length][keys.length];
		int[] psa = new int[freq.length];

		psa[0] = freq[0];
		for (int i = 1; i < freq.length; i++) {
			psa[i] = psa[i - 1] + freq[i];
		}

		for (int g = 0; g < dp.length; g++) {
			for (int i = 0, j = g; j < dp[0].length; j++, i++) {

				if (g == 0) {
					dp[i][j] = freq[i];
				} else if (g == 1) {
					dp[i][j] = Math.min(1 * freq[i] + 2 * freq[j], 2 * freq[i] + 1 * freq[j]);
				} else {

					dp[i][j] = Integer.MAX_VALUE;
					for (int k2 = g + 1, k1 = 1; k2 >= 1; k2--, k1++) {
						int left = (j - k2) == -1 ? 0 : dp[i][j - k2];
						int right = (i + k1) == dp.length ? 0 : dp[i + k1][j];

						int factor = psa[j] - (i > 0 ? psa[i - 1] : 0);
						dp[i][j] = Math.min(dp[i][j], left + right + factor);
					}

				}
			}
		}

		return dp[0][keys.length - 1];

	}

}
