package com.ds.level1.sorting;

import java.util.Scanner;

/*
 * 1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
2. You have to find the smallest element in O(logN) time-complexity
 */

public class PivotInSortedAndRotatedArray {

	public static int findPivot(int[] arr) {
		// write your code here
		int l = 0;
		int h = arr.length - 1;

		while (l < h) {
			int mid = (l + h) / 2;
			if (arr[mid] < arr[h]) {
				h = mid;
			} else {
				l = mid + 1;
			}
		}
		return arr[h];
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int pivot = findPivot(arr);
		System.out.println(pivot);
	}

}
