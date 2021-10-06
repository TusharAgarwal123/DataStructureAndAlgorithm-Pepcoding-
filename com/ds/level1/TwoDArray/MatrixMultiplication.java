package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class MatrixMultiplication {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int ar[][] = new int[r1][c1];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[0].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		int br[][] = new int[r2][c2];
		for (int i = 0; i < br.length; i++) {
			for (int j = 0; j < br[0].length; j++) {
				br[i][j] = sc.nextInt();
			}
		}

		if (c1 != r2) {
			System.out.println("Invalid input");
			return;
		}

		int pr[][] = new int[r1][c2];

		for (int i = 0; i < pr.length; i++) {
			for (int j = 0; j < pr[0].length; j++) {
				for (int k = 0; k < c1; k++) {
					pr[i][j] += ar[i][k] * br[k][j];
				}
			}
		}

		for (int i = 0; i < pr.length; i++) {
			for (int j = 0; j < pr[0].length; j++) {
				System.out.print(pr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
