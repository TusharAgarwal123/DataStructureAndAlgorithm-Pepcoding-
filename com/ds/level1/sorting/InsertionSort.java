package com.ds.level1.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {

		int ar[] = { 255, 98, 12, 10, 4, 8, 3 };
		// insertionSort(ar);

		recursiveInsertionSort(ar, 0, ar.length - 1);

		System.out.println(Arrays.toString(ar));

	}

	public static void insertionSort(int[] ar) {

		int n = ar.length;
		for (int i = 0; i < n - 1; i++) {

			for (int j = i + 1; j > 0; j--) {

				if (ar[j] < ar[j - 1]) {
					int temp = ar[j];
					ar[j] = ar[j - 1];
					ar[j - 1] = temp;
				} else {
					break;
				}

			}

		}

	}

	// recursive approach
	public static void recursiveInsertionSort(int ar[], int i, int j) {

		if (i < 0) {
			return;
		}
		if (i == j) {
			return;
		}

		if (ar[i + 1] < ar[i]) {
			swap(ar, i + 1, i);
			recursiveInsertionSort(ar, i - 1, j);
		}
		recursiveInsertionSort(ar, i + 1, j);

	}

	private static void swap(int[] ar, int i, int j) {

		int t = ar[i];
		ar[i] = ar[j];
		ar[j] = t;
	}

}
