package com.ds.level1.sorting;

public class MoveAll0ToEnd {

	/*
	 * we have an array we have to move all 0's to end.
	 */

	public static void sort(int[] arr) {
		// write your code here
		int i = 0;
		int j = 0;
		while (j < arr.length) {
			if (arr[j] == 0) {
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

		int[] arr = { 2, 3, 0, 5, 0, 1, 0, 0, 6 };
		sort(arr);
		print(arr);
	}

}
