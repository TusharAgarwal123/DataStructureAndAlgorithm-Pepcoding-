package com.ds.level1.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int ar[] = { 7, 5, 4, 2, -3 };
		// selectionSort(ar);
		recursiveSelectionSort(ar, 0, ar.length - 1);

		System.out.println(Arrays.toString(ar));

	}

	public static void selectionSort(int[] ar) {

		int n = ar.length;

		for (int i = 0; i < n - 1; i++) {

			int min = i;
			for (int j = i; j < n; j++) {

				if (ar[j] < ar[min]) {
					min = j;
				}

			}

			int temp = ar[i];
			ar[i] = ar[min];
			ar[min] = temp;

		}

	}

	// recursive approach

	public static void recursiveSelectionSort(int ar[], int i, int j) {

		if (i == j) {
			return;
		}

		int minIndex = findMinIndex(ar, i, j);
		swap(ar, i, minIndex);
		recursiveSelectionSort(ar, i + 1, j);

	}

	private static void swap(int[] ar, int i, int minIndex) {

		int t = ar[i];
		ar[i] = ar[minIndex];
		ar[minIndex] = t;
	}

	private static int findMinIndex(int[] ar, int i, int j) {

		int minIndex = i;
		for (int k = i + 1; k <= j; k++) {
			if (ar[k] < ar[minIndex]) {
				minIndex = k;
			}
		}
		return minIndex;

	}

}
