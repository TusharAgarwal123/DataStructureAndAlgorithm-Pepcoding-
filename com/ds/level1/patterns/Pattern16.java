package com.ds.level1.patterns;

public class Pattern16 {

	public static void main(String[] args) {

		int n = 4;

		int nos = (n * 2) - 3;
		int nst = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nst; j++) {
				System.out.print(j + "\t");
			}

			for (int k = 1; k <= nos; k++) {
				System.out.print("\t");
			}

			if (i == n) {
				nst--;
			}
			for (int j = nst; j >= 1; j--) {
				System.out.print(j + "\t");
			}

			System.out.println();
			nst++;
			nos -= 2;

		}

	}
}
