package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n and a number k in separate lines, representing the number of fences and
 *  number of colors.
2. You are required to calculate and print the number of ways in which the fences could be painted so that
 not more than two consecutive  fences have same colors.
 */

public class PaintFence {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int ii = k; // last two have same color
		int ij = k * (k - 1); // last two have different color

		int total = ii + ij;

		for (int i = 3; i <= n; i++) {
			ii = ij;
			ij = total * (k - 1);
			total = ii + ij;
		}

		System.out.println(total);

	}

}
