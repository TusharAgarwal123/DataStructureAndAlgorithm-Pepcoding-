package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class WavePrint {

	public static void main(String[] args) {
		System.out.println("Enter the value of n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		for (int diag = 0; diag < (2 * n) - 1; diag++) {

			int i = 0;
			int j = 0;

			if (diag < n - 1) { // first half
				if (diag % 2 == 0) {
					i = (n - 1) - diag;
					j = 0;
				} else {
					i = n - 1;
					j = diag;
				}
			} else if (diag > n - 1) { // third half
				if (diag % 2 == 0) {
					i = 0;
					j = diag - (n - 1);
				} else {
					i = ((n - 1) * 2) - diag;
					j = n - 1;
				}
			} else { // middle
				if (n % 2 == 0) {
					i = n - 1;
					j = n - 1;
				} else {
					i = 0;
					j = 0;
				}
			}

			if (diag % 2 == 0) {
				while (i < n && j < n) {
					System.out.print(ar[i][j] + " ");
					i++;
					j++;
				}
			} else {
				while (i >= 0 && j >= 0) {
					System.out.print(ar[i][j] + " ");
					i--;
					j--;
				}
			}

		}

	}

}
