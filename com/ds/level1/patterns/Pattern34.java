package com.ds.level1.patterns;

public class Pattern34 {

	public static void main(String[] args) throws Exception {

		int n = 6;

		char ch = 'A';

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1 || j == i) {
					System.out.print(ch);
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
			ch++;
		}

	}

}
