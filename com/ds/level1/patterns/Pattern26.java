package com.ds.level1.patterns;

public class Pattern26 {

	public static void main(String[] args) {
		int n = 7;
		int nst = n;
		int nos = 0;

		for (int i = 1; i <= n; i++) {
			char ch = 'A';
			for (int j = 1; j <= nst; j++) {
				System.out.print(ch + "\t");
				ch++;
			}

			for (int j = 1; j <= nos; j++) {
				System.out.print("\t");
			}

			if (i == 1) {
				nst--;
				ch--;
			}
			for (int j = 1; j <= nst; j++) {
				ch--;
				System.out.print(ch + "\t");
			}

			System.out.println();

			if (i != 1) {
				nst--;
			}
			if (i < 2) {
				nos++;
			} else {
				nos += 2;
			}

		}
	}

}
