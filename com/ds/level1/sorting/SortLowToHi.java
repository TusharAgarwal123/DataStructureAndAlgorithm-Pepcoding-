package com.ds.level1.sorting;

public class SortLowToHi {

	/*
	 * we have an array and two number i.e a nad b. we have to sort the array such
	 * that all element less than a comes first and all element greater than a and
	 * less than b comes next then all greater than b comes at last.
	 */

	public static void sort(int[] arr, int a, int b) {
		// write your code here
		int i = 0;
		int j = 0;
		int k = arr.length - 1;
		while (i <= k) {
			if (arr[i] > a && arr[i] < b) {
				i++;
			} else if (arr[i] > b) {
				swap(arr, i, k);
				k--;
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
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) throws Exception {

		int[] arr = { 5, 7, 9, 10, 2, 1, 3, 6, 4, 8 };
		sort(arr, 3, 7);
		print(arr);
	}

}
