package com.ds.level1.patterns;

public class Pattern17 {

	public static void main(String[] args) {

		int n = 5;
		int nos = n / 2;
		int nst = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nos; j++) {
				if (i == (n / 2) + 1) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}

			for (int j = 1; j <= nst; j++) {
				System.out.print("*\t");
			}

			System.out.println();

			if (i <= n / 2) {
				nst++;
			} else {
				nst--;
			}
		}

	}

}
