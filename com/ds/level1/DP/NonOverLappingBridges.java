package com.ds.level1.DP;

import java.util.Arrays;

//Building Bridges on gfg.

public class NonOverLappingBridges {

	public static void main(String[] args) {

		int[][] ar = { { 8, 1 }, { 1, 2 }, { 4, 3 }, { 3, 4 }, { 5, 5 }, { 2, 6 }, { 6, 7 }, { 7, 8 } };

		System.out.println(maxNonOverLappingBridges(ar));

	}

	// O(n^2)
	public static int maxNonOverLappingBridges(int[][] ar) {

		// sorting on north.
		Arrays.sort(ar, (b1, b2) -> {
			if (b1[0] != b2[0]) {
				return b1[0] - b2[0];
			} else {
				return b1[1] - b2[1];
			}
		});

		// finding lis on south
		int[] lis = new int[ar.length];
		lis[0] = 1;

		for (int i = 1; i < lis.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (ar[j][1] <= ar[i][1]) {
					max = Math.max(max, lis[j]);
				}
			}

			lis[i] = max + 1;
		}

		int len = 0;
		for (int x : lis) {
			len = Math.max(len, x);
		}

		return len;

	}

}
