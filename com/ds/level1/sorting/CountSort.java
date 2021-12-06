package com.ds.level1.sorting;

public class CountSort {

	public static void sort(int[] arr, int min, int max) {
		// write your code here

		int n = arr.length;
		int range = max - min + 1;
		int fr[] = new int[range];
		int ans[] = new int[n];

		// collecting the frequency.

		for (int i = 0; i < n; i++) {
			int val = arr[i] - min;
			fr[val]++;
		}

		// converting the frequency array into prefix sum array.

		for (int i = 1; i < fr.length; i++) {
			fr[i] = fr[i] + fr[i - 1];
		}

		// fill the answer array

		for (int i = n - 1; i >= 0; i--) {
			int val = arr[i];
			int pos = fr[val - min];
			ans[pos - 1] = val;
			fr[val - min]--;
		}

		// fill the original array
		for (int i = 0; i < n; i++) {
			arr[i] = ans[i];
		}

	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) throws Exception {

		int[] arr = { 5, 3, 7, 3, 5, 7, 2, 5, 2, 7, 6, 5, 6 };
		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		sort(arr, min, max);
		print(arr);
	}

}
