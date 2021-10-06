package com.ds.level1.patterns;

public class Pattern19 {

	public static void main(String[] args) {

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {

				if (i == 1) {
					if (j == n || j <= (n / 2) + 1) {
						System.out.print("*\t");
					} else {
						System.out.print("\t");
					}
				} else if (i < (n / 2) + 1) {
					if (j == n || j == (n / 2) + 1) {
						System.out.print("*\t");
					} else {
						System.out.print("\t");
					}
				} else if (i == (n / 2) + 1) {
					System.out.print("*\t");
				} else if (i < n) {
					if (j == 1 || j == (n / 2) + 1) {
						System.out.print("*\t");
					} else {
						System.out.print("\t");
					}
				} else {
					if (j == 1 || j >= (n / 2) + 1) {
						System.out.print("*\t");
					} else {
						System.out.print("\t");
					}
				}

			}
			System.out.println();
		}
	}

}
