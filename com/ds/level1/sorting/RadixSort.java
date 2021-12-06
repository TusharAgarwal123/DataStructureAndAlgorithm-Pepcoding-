package com.ds.level1.sorting;

public class RadixSort {

	// radix sort use count sort internally.

	public static void radixSort(int[] arr) {
		// write code here

		int n = arr.length;
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		int place = 1;
		while ((max / place) > 0) {
			countSort(arr, place);
			place = place * 10;
		}

	}

	public static void countSort(int[] arr, int exp) {
		// write code here

		int n = arr.length;
		int fr[] = new int[10];
		int ans[] = new int[n];

		for (int i = 0; i < n; i++) {

			int val = (arr[i] / exp) % 10;
			fr[val]++;

		}

		for (int i = 1; i < fr.length; i++) {

			fr[i] = fr[i] + fr[i - 1];

		}

		for (int i = n - 1; i >= 0; i--) {

			int val = (arr[i] / exp) % 10;
			int pos = fr[val];
			ans[pos - 1] = arr[i];
			fr[val]--;

		}

		for (int i = 0; i < n; i++) {

			arr[i] = ans[i];

		}

	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {
		int arr[] = { 2, 8, 6, 90, 14, 56, 11, 58 };
		radixSort(arr);
		print(arr);
	}

}
