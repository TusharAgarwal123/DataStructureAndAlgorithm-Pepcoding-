package com.ds.level1.array;

import java.util.Scanner;

public class BarChart {

	public static void main(String[] args) throws Exception {

		System.out.println("...");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		int max = ar[0];
		for (int i = 0; i < n; i++) {
			if (ar[i] > max) {
				max = ar[i];
			}
		}

		for (int ht = max; ht >= 1; ht--) {

			for (int i = 0; i < n; i++) {
				if (ar[i] >= ht) {
					System.out.print("*\t");
				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}

	}

}
