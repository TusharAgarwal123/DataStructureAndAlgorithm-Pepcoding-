package com.ds.level1.DP;

import java.util.Scanner;

//Paint House - Many Colors

/*
 *  1.You are given a number n and a number k separated by a space, representing the number of houses
 *   and number of colors.
2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house
 with one of the k colors.
3. You are required to calculate and print the minimum cost of painting all houses without painting any
 consecutive house with same color.
 */

public class PaintHouseManyColors {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		int ar[][] = new int[n][k];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		long ans = paintHouse_Greedy(n, ar);

		System.out.println(ans);

	}

	public static long paintHouse_Greedy(int n, int ar[][]) {

		int min = Integer.MAX_VALUE;
		int smin = Integer.MAX_VALUE;

		for (int j = 0; j < ar[0].length; j++) {
			if (ar[0][j] <= min) {
				smin = min;
				min = ar[0][j];
			} else if (ar[0][j] <= smin) {
				smin = ar[0][j];
			}
		}

		for (int i = 1; i < ar.length; i++) {
			int cmin = Integer.MAX_VALUE;
			int csmin = Integer.MAX_VALUE;

			for (int j = 0; j < ar[i].length; j++) {
				if (ar[i - 1][j] != min) {
					ar[i][j] += min;
				} else {
					ar[i][j] += smin;
				}

				if (ar[i][j] <= cmin) {
					csmin = cmin;
					cmin = ar[i][j];
				} else if (ar[i][j] <= csmin) {
					csmin = ar[i][j];
				}
			}
			min = cmin;
			smin = csmin;
		}

		return min;

	}

}
