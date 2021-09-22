package com.ds.level1.patterns;

public class Pattern12 {

	public static void main(String[] args) {

		// printing fibonacci no in triangle

		int n = 5;
		int nst = 1;
		int a = 0;
		int b = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= nst; j++) {
				System.out.print(a + "\t");
				int c = a + b;
				a = b;
				b = c;
			}
			nst++;
			System.out.println();
		}

	}
}
