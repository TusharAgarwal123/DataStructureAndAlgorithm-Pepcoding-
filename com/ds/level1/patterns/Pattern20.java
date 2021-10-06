package com.ds.level1.patterns;

public class Pattern20 {

	public static void main(String[] args) {

		int n = 5;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j == 1 || j == n) {
					System.out.print("*\t");
				} else if (i > n / 2 && (i == j || i + j == n + 1)) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}

	}

}
