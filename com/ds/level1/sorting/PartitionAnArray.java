package com.ds.level1.sorting;

public class PartitionAnArray {

	/*
	 * you have given an array and a pivot element,you have to arrange all the
	 * smaller or equal element to left of the pivot and all the greater element to
	 * right of the pivot.
	 */

	public static void main(String[] args) {

		int ar[] = { 7, 9, 4, 8, 3, 6, 2, 1, 5 };
		int k = 5;

		int i = 0;
		int j = 0;

		while (i < ar.length) {
			if (ar[i] > k) {
				i++;
			} else {
				swap(ar, i, j);
				i++;
				j++;
			}
		}

		System.out.println(j);

		for (int x : ar) {
			System.out.print(x + " ");
		}

	}

	private static void swap(int[] ar, int i, int j) {

		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;

	}

}
