package com.ds.level1.patterns;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		System.out.println("Enter the n:");
		Scanner scn = new Scanner(System.in);

		// write ur code here
		int n = scn.nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				System.out.print("*" + "\t");
			}
			System.out.println();
		}

	}

}
