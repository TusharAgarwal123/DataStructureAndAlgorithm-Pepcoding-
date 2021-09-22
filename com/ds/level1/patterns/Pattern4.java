package com.ds.level1.patterns;

import java.util.Scanner;

public class Pattern4 {

	public static void main(String[] args) {
		System.out.println("Enter the n:");
		Scanner scn = new Scanner(System.in);

		// write ur code here
		int n = scn.nextInt();

		for (int i = 1; i <= n; i++) {

			for (int x = 1; x <= i - 1; x++) {
				System.out.print("\t");
			}

			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print("*" + "\t");
			}
			System.out.println();
		}

	}
}
