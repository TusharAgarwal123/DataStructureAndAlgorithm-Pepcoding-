package com.ds.level1.array;

import java.util.Scanner;

public class FirstIndexAndLastIndex {

	// you have an array and element, you have to print it's first index and last
	// index.

	// we will use binary search for the problem.

	public static void main(String[] args) throws Exception {

		// write your code here
		System.out.println("-----");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ar[] = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = sc.nextInt();
		}
		int k = sc.nextInt();

		int l = 0;
		int h = ar.length - 1;
		int fi = -1;
		while (l <= h) {
			int mid = (l + h) / 2;

			if (ar[mid] == k) {
				fi = mid;
				h = mid - 1;
			} else if (ar[mid] > k) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		System.out.println(fi);
		l = 0;
		h = ar.length - 1;

		int li = -1;
		while (l <= h) {
			int mid = (l + h) / 2;

			if (ar[mid] == k) {
				li = mid;
				l = mid + 1;
			} else if (ar[mid] > k) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		System.out.println(li);
	}

}
