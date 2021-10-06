package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class LowerDiagonal {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();

		int ar[][] = new int[r][r];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		for (int g = 0; g < r; g++) {
			for (int i = g, j = 0; i < r; i++, j++) {
				System.out.println(ar[i][j]);
			}
		}
	}
}
