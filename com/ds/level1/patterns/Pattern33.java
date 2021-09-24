package com.ds.level1.patterns;

public class Pattern33 {

	public static void main(String[] args) {
		int n = 5;
		int nst = n;
		for (int i = 1; i <= n; i++) {
			for (int j = nst; j >= 1; j--) {
				if (i == j) {
					System.out.print("*\t");
				} else {
					System.out.print(j + "\t");
				}
			}
			System.out.println();
		}
	}

}
