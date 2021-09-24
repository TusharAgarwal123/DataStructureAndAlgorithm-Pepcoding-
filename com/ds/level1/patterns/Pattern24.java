package com.ds.level1.patterns;

public class Pattern24 {

	public static void main(String[] args) {
		int n = 5;
		int nst = n / 2;
		int nos = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nst; j++) {
				System.out.print("*\t");
			}

			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}

			for (int j = 1; j <= nst; j++) {
				System.out.print("*\t");
			}

			System.out.println();
			if (i <= n / 2) {
				nst--;
				nos += 2;
			} else {
				nst++;
				nos -= 2;
			}
		}
	}

}
