package com.ds.level1.DP;

import java.util.Arrays;

//354. Russian Doll Envelopes

/*
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and
 *  the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater
 than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.
 */

public class RussianDollEnvelopes {

	// O(nlogn)
	public int maxEnvelopes(int[][] envelopes) {

		// sorting on width
		Arrays.sort(envelopes, (e1, e2) -> {
			if (e1[0] != e2[0]) {
				return e1[0] - e2[0];
			} else {
				return e2[1] - e1[1];
				// if width is not equal then reverse sort on height.
			}
		});

		int[] tails = new int[envelopes.length];
		int len = 1;
		tails[0] = envelopes[0][1];

		for (int i = 1; i < tails.length; i++) {
			if (envelopes[i][1] > tails[len - 1]) {
				len++;
				tails[len - 1] = envelopes[i][1];
			} else {
				int idx = Arrays.binarySearch(tails, 0, len - 1, envelopes[i][1]);
				if (idx < 0) {
					idx = idx * -1;
					idx = idx - 1;
				}

				tails[idx] = envelopes[i][1];
			}
		}

		return len;

	}

	// O(n^2)
	public int maxEnvelopes2(int[][] envelopes) {

		// sorting on width
		Arrays.sort(envelopes, (e1, e2) -> {
			if (e1[0] != e2[0]) {
				return e1[0] - e2[0];
			} else {
				return e2[1] - e1[1];
				// if width is not equal then reverse sort on height.
			}
		});

		// finding lis on height.
		int[] lis = new int[envelopes.length];
		lis[0] = 1;

		for (int i = 1; i < lis.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (envelopes[j][1] < envelopes[i][1]) {
					max = Math.max(max, lis[j]);
				}
			}
			lis[i] = max + 1;
		}

		int ans = 0;
		for (int x : lis) {
			ans = Math.max(ans, x);
		}

		return ans;

	}

}
