package com.ds.level2.DP;

//Dyck Path on gfg

/*
 * Consider a N x N grid with indexes of top left corner as (0, 0). Dyck path is a staircase walk from
 *  bottom left, i.e., (N-1, 0) to top right, i.e., (0, N-1) that lies above the diagonal cells (or cells
 *   on line from bottom left to top right).

The task is to count the number of Dyck Paths from (N-1, 0) to (0, N-1).

Here are the some of the possible paths for different N.


 */

public class DyckPath {

	static Long dyckPaths(int N) {

		long[] dp = new long[N + 1];

		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				int right = i - j - 1;
				long val = (dp[j] * dp[right]);
				dp[i] = (dp[i] + val);

			}
		}

		return dp[N];
	}

}
