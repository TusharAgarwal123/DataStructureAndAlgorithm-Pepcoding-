package com.ds.level1.sorting;

public class Sort012 {

	public static void sort012(int[] arr) {
		// write your code here

		int i = 0;
		int j = 0;
		int k = arr.length - 1;

		while (j <= k) {
			if (arr[j] == 2) {
				swap(arr, j, k);
				k--;
			} else if (arr[j] == 1) {
				j++;
			} else {
				swap(arr, i, j);
				i++;
				j++;
			}
		}

	}

	// used for swapping ith and jth elements of array
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {

		int arr[] = { 0, 1, 2, 2, 1, 0, 0, 1, 2 };

		sort012(arr);
		print(arr);
	}

}
