package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class SpiralPrinting1 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int ar[][] = new int[r][c];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		// printing first column

		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i][0]);
		}

		// printing last row

		for (int j = 1; j < ar[0].length - 1; j++) {
			System.out.println(ar[ar.length - 1][j]);
		}

		// printing last column

		for (int i = ar.length - 1; i >= 0; i--) {
			System.out.println(ar[i][ar[0].length - 1]);
		}

		// printing remaining part

		for (int i = 0; i < ar.length - 1; i++) {

			if (i % 2 == 0) {
				for (int j = ar[0].length - 2; j >= 1; j--) {
					System.out.println(ar[i][j]);
				}
			} else {
				for (int j = 1; j <= ar[0].length - 2; j++) {
					System.out.println(ar[i][j]);
				}
			}

		}

	}

}
