package com.ds.level1.patterns;

public class Pattern25 {

	public static void main(String[] args) {
		int n = 5;
		int nst = 1;
		int nos = 2 * n - 3;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nst; j++) {
				System.out.print("*\t");
			}

			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}

			// special case.
			if (i == n) {
				nst--;
			}
			for (int j = 1; j <= nst; j++) {
				System.out.print("*\t");
			}

			System.out.println();

			nst++;
			nos -= 2;

		}
	}

}
