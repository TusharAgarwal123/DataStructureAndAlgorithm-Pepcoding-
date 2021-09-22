package com.ds.level1.patterns;

public class Pattern15 {

	public static void main(String[] args) {

		int n = 5;
		int stars = 1;
		int spaces = n / 2;
		int oval = 1;
		for (int i = 1; i <= n; i++) {
			int val = oval;
			for (int j = 1; j <= spaces; j++) {
				System.out.print("\t");
			}
			for (int j = 1; j <= stars; j++) {
				System.out.print(val + "\t");
				if (j <= stars / 2) {
					val++;
				} else {
					val--;
				}
			}
			System.out.println();
			if (i <= n / 2) {
				oval++;
				stars += 2;
				spaces--;
			} else {
				oval--;
				stars -= 2;
				spaces++;
			}
		}
	}
}
