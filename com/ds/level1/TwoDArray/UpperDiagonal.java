package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class UpperDiagonal {

	// in first upper diagonal the difference row and col is 0
	// in second upper diagonal the difference row and col is 1
	//
	// in last upper diagonal the difference row and col is n-1
	// so we will print diagonal diff wise from 0 to n-1.
	// and in each diagonal row is start from 0 and column start from diff.

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
			for (int i = 0, j = g; j < r; i++, j++) {
				System.out.println(ar[i][j]);
			}
		}
	}

}
