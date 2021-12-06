package com.ds.level1.patterns;

import java.util.Scanner;

public class HollowSquare {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int val = 1;

		for (int i = 1; i <= n; i++) {

			int oval = val;

			for (int j = 1; j <= n; j++) {
				if (i == 1 || i == n) {
					System.out.print(oval + " ");
				} else {
					if (j == 1 || j == n) {
						System.out.print(oval + " ");
					} else {
						System.out.print("* ");
					}
				}
				oval++;
			}

			System.out.println();

			if (n % 2 == 0) {

				if (i < n / 2) {
					val = val + (2 * n);
				} else if (i == n / 2) {
					val = val + n;
				} else {
					val = val - (2 * n);
				}

			} else {
				if (i <= n / 2) {
					val = val + (2 * n);
				} else if (i == n / 2 + 1) {
					val = val - n;
				} else {
					val = val - (2 * n);
				}
			}

		}

	}

}
