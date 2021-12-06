package com.ds.level1.array;

import java.util.Scanner;

public class BinarySearch {

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
				break;
			} else if (ar[mid] > k) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		System.out.println(fi);
	}
}
