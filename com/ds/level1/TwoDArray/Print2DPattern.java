package com.ds.level1.TwoDArray;

import java.util.Scanner;

public class Print2DPattern {

	public static void main(String[] args) {
		System.out.println("Enter the value of n");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int val = 1;
		for (int i = 1; i <= n; i++) {
			int inval = val;
			for (int j = 1; j <= n; j++) {
				System.out.print(inval + "\t");
				inval++;
			}

			if (n % 2 == 0) {

				if (i < (n / 2)) { // upper half
					val += 2 * n;
				} else if (i == (n / 2)) { // middle
					val += n;
				} else { // lower half
					val -= 2 * n;
				}

			} else {
				if (i <= (n / 2)) { // upper half
					val += 2 * n;
				} else if (i == (n / 2) + 1) { // middle
					val -= n;
				} else { // lower half
					val -= 2 * n;
				}
			}

			System.out.println();
		}

	}

}
