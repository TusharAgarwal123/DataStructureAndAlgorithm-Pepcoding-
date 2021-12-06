package com.ds.level1.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int ar[] = { 7, 5, 4, 2, 0 };
		// bubbleSort(ar);

		recursiveBubbleSort(ar, 0, ar.length - 1);

		System.out.println(Arrays.toString(ar));

	}

	public static void bubbleSort(int[] ar) {

		int n = ar.length;

		for (int i = 0; i < n - 1; i++) {

			boolean sorted = true;

			for (int j = 0; j < n - 1 - i; j++) {

				if (ar[j] > ar[j + 1]) {
					int temp = ar[j];
					ar[j] = ar[j + 1];
					ar[j + 1] = temp;
					sorted = false;
				}

			}
			if (sorted) {
				break;
			}

		}

	}

	// recursive approach
	public static void recursiveBubbleSort(int ar[], int i, int j) {

		if (j == 0) {
			return;
		}

		if (i == j) {
			recursiveBubbleSort(ar, 0, j - 1);
			return;
		}

		if (ar[i] > ar[i + 1]) {
			swap(ar, i, i + 1);
		}

		recursiveBubbleSort(ar, i + 1, j);

	}

	private static void swap(int[] ar, int i, int j) {

		int t = ar[i];
		ar[i] = ar[j];
		ar[j] = t;
	}

}
