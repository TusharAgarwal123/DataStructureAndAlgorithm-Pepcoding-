package com.ds.level1.DP;

import java.util.Arrays;

//1235. Maximum Profit in Job Scheduling

/*
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a
 *  profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that
 there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.


 */

public class MaximumProfitInJobScheduling {

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

		int[][] ar = new int[startTime.length][3];

		for (int i = 0; i < ar.length; i++) {
			ar[i][0] = startTime[i];
			ar[i][1] = endTime[i];
			ar[i][2] = profit[i];
		}

		Arrays.sort(ar, (j1, j2) -> {
			if (j1[0] != j2[0]) {
				return j1[0] - j2[0];
			} else {
				return j1[1] - j2[1];
			}
		});

		int[] lis = new int[ar.length];
		lis[0] = ar[0][2]; // because we have to do the first job.

		for (int i = 1; i < lis.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (ar[j][1] <= ar[i][0]) {
					max = Math.max(max, lis[j]);
				}
			}

			lis[i] = max + ar[i][2];
		}

		int len = 0;
		for (int x : lis) {
			len = Math.max(len, x);
		}

		return len;

	}

}
