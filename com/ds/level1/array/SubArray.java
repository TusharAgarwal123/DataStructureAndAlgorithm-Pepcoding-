package com.ds.level1.array;

import java.util.Scanner;

public class SubArray {

	// you have an array you have to print all the subarray of array.
	// there are (n*(n+1))/2 subarray of n.

	public static void main(String[] args) throws Exception {
		// write your code here

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(ar[k] + "\t");
				}
				System.out.println();
			}
		}

	}

}
