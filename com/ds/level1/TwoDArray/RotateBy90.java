package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class RotateBy90 {

	// to rotate it by 90 first we will find the transpose and then we will reverse
	// it's row.

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		// transpose

		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < i; j++) {
				int t = ar[i][j];
				ar[i][j] = ar[j][i];
				ar[j][i] = t;
			}
		}

		// reverse row by row

		for (int i = 0; i < ar.length; i++) {
			int li = 0;
			int ri = ar.length - 1;
			while (li <= ri) {
				int t = ar[i][li];
				ar[i][li] = ar[i][ri];
				ar[i][ri] = t;
				li++;
				ri--;
			}
		}
		display(ar);

	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
