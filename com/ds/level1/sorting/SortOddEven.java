package com.ds.level1.sorting;

/*
  * we have an array, we have to sort array such that all even comes first and then all odd.
  */

public class SortOddEven {

	public static void sortOddEven(int[] arr) {
		// write your code here
		int i = 0;
		int j = 0;
		while (j < arr.length) {
			if (arr[j] % 2 == 1) {
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
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) throws Exception {

		int[] arr = { 2, 3, 4, 5, 6, 7, 8, 9 };
		sortOddEven(arr);
		print(arr);
	}

}
