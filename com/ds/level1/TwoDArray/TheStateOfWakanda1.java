package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class TheStateOfWakanda1 {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int ar[][] = new int[r][c];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		for (int j = 0; j < ar[0].length; j++) {
			if (j % 2 == 0) {
				for (int i = 0; i < ar.length; i++) {
					System.out.println(ar[i][j]);
				}
			} else {
				for (int i = ar.length - 1; i >= 0; i--) {
					System.out.println(ar[i][j]);
				}
			}
		}

	}

}
