package com.ds.level1.TwoDArray;

import java.util.Scanner;

/*
 * 
 * You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m numbers representing the elements of the matrix.
You will be given a ring number 's' representing the ring of the matrix. For details, refer to image.

shell-rotate

You will be given a number 'r' representing number of rotations in an anti-clockwise manner of the specified ring.
You are required to rotate the 's'th ring by 'r' rotations and display the rotated matrix.
 */

public class RingRotate {

	public static void main(String[] args) throws Exception {
		// write your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int ar[][] = new int[n][m];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		int s = sc.nextInt();
		int r = sc.nextInt();

		int oneD[] = fillarrayFromShell(ar, s);

		rotateArray(oneD, r);

		fillShellFromOdeDArray(ar, s, oneD);

		display(ar);

	}

	public static void fillShellFromOdeDArray(int ar[][], int s, int oneD[]) {

		int minr = s - 1;
		int minc = s - 1;
		int maxr = ar.length - s;
		int maxc = ar[0].length - s;

		int id = 0;

		// left wall

		for (int i = minr, j = minc; i <= maxr; i++) {
			ar[i][j] = oneD[id];
			id++;
		}

		// bottom wall

		for (int j = minc + 1, i = maxr; j <= maxc; j++) {
			ar[i][j] = oneD[id];
			id++;
		}

		// right wall

		for (int i = maxr - 1, j = maxc; i >= minr; i--) {
			ar[i][j] = oneD[id];
			id++;
		}

		// top wall

		for (int j = maxc - 1, i = minr; j >= minc + 1; j--) {
			ar[i][j] = oneD[id];
			id++;
		}

	}

	public static void reverse(int ar[], int li, int ri) {

		while (li <= ri) {
			int t = ar[li];
			ar[li] = ar[ri];
			ar[ri] = t;
			li++;
			ri--;
		}

	}

	public static void rotateArray(int ar[], int k) {

		k = k % ar.length;
		if (k < 0) {
			k = k + ar.length;
		}

		reverse(ar, 0, ar.length - k - 1);
		reverse(ar, ar.length - k, ar.length - 1);
		reverse(ar, 0, ar.length - 1);

	}

	public static int[] fillarrayFromShell(int ar[][], int s) {

		int minr = s - 1;
		int minc = s - 1;
		int maxr = ar.length - s;
		int maxc = ar[0].length - s;

		// no of element in shell
		int count = (2 * (maxr - minr + 1)) + (2 * (maxc - minc + 1)) - 4;

		int oneD[] = new int[count];
		int id = 0;

		// left wall

		for (int i = minr, j = minc; i <= maxr; i++) {
			oneD[id] = ar[i][j];
			id++;
		}

		// bottom wall

		for (int j = minc + 1, i = maxr; j <= maxc; j++) {
			oneD[id] = ar[i][j];
			id++;
		}

		// right wall

		for (int i = maxr - 1, j = maxc; i >= minr; i--) {
			oneD[id] = ar[i][j];
			id++;
		}

		// top wall

		for (int j = maxc - 1, i = minr; j >= minc + 1; j--) {
			oneD[id] = ar[i][j];
			id++;
		}

		return oneD;

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
