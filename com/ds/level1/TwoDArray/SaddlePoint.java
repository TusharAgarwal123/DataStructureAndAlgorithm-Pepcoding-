package com.ds.level1.TwoDArray;

import java.util.Scanner;

/*
 * 1. You are given a square matrix of size 'n'. You are given n*n elements of the square matrix. 
2. You are required to find the saddle price of the given matrix and print the saddle price. 
3. The saddle price is defined as the least price in the row but the maximum price in the column of the matrix.
 */

public class SaddlePoint {

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[][] = new int[n][n];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		//traversing row by row and finding the least element column index and then checking in that 
		//column if there is any element greater than this or not.
		
		for (int i = 0; i < ar.length; i++) {

			int lci = 0;
			for (int j = 1; j < ar[0].length; j++) {
				if (ar[i][j] < ar[i][lci]) {
					lci = j;
				}
			}

			boolean flag = true;
			for (int k = 0; k < ar.length; k++) {

				if (ar[k][lci] > ar[i][lci]) {
					flag = false;
					break;
				}

			}
			if (flag == true) {
				System.out.println(ar[i][lci]);
				return;
			}

		}

		System.out.println("Invalid input");

	}

}
