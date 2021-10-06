package com.ds.level1.array;

import java.util.Scanner;

public class FloorAndCeil {

	// you have an array and element, you have to print it's ceil and floor.

	// we are using binary search for this problem.

	public static void main(String[] args) throws Exception {
		// write your code here

		System.out.println("----");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int k = sc.nextInt();

		int l = 0;
		int h = ar.length - 1;
		int floor = -1;
		int ceil = -1;

		while (l <= h) {
			int mid = (l + h) / 2;
			if (ar[mid] == k) {
				floor = ar[mid];
				ceil = ar[mid];
				break;
			} else if (ar[mid] > k) {
				h = mid - 1;
				ceil = ar[mid];
			} else {
				l = mid + 1;
				floor = ar[mid];
			}
		}

		System.out.println(ceil);
		System.out.println(floor);

	}

}
