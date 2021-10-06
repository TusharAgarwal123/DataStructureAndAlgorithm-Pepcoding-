package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class SearchInSorted2DArray {

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

		int x = sc.nextInt();

		int a = 0;
		int b = ar[0].length - 1;

		while (a < ar.length && b >= 0) {

			if (ar[a][b] == x) {
				System.out.println(a);
				System.out.println(b);
				return;

			} else if (ar[a][b] > x) {
				b--;
			} else {
				a++;
			}

		}
		System.out.println("Not Found");

	}

}
