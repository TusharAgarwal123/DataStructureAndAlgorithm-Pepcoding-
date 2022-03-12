package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
     any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
 */

public class GoldMine {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int ar[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		System.out.println(findMaxGold(n, m, ar));

	}

	public static int findMaxGold(int n, int m, int ar[][]) {

		int dp[][] = new int[n][m];

		// we will traverse column wise.
		for (int j = ar[0].length - 1; j >= 0; j--) {
			for (int i = 0; i < ar.length; i++) {

				// if it is last column.
				if (j == ar[0].length - 1) {
					dp[i][j] = ar[i][j];
				} else if (i == 0) { // if it is first row.
					dp[i][j] = ar[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
				} else if (i == ar.length - 1) { // if it is last row.
					dp[i][j] = ar[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
				} else {
					dp[i][j] = ar[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
				}

			}
		}

		// now find maximum from first column.
		int max = dp[0][0];
		for (int i = 1; i < ar.length; i++) {
			if (dp[i][0] > max) {
				max = dp[i][0];
			}
		}

		return max;

	}

	public static int findMaxGold2(int n, int m, int ar[][]) {

		int dp[][] = new int[n][m];
		int dir[][] = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

		for (int sc = m - 1; sc >= 0; sc--) {
			for (int sr = n - 1; sr >= 0; sr--) {
				if (sc == m - 1) {
					dp[sr][sc] = ar[sr][sc];
					continue;
				}

				int maxGold = 0;
				for (int d = 0; d < dir.length; d++) {
					int r = sr + dir[d][0];
					int c = sc + dir[d][1];

					if (r >= 0 && c >= 0 && r < n && c < m) {
						maxGold = Math.max(ar[sr][sc] + dp[r][c], maxGold);
					}

				}

				dp[sr][sc] = maxGold;
			}
		}

		int maxGold = 0;
		for (int i = 0; i < n; i++) {
			if (dp[i][0] > maxGold) {
				maxGold = dp[i][0];
			}
		}

		return maxGold;
	}

}
