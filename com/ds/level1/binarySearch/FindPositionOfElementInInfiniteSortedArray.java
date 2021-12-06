package com.ds.level1.binarySearch;

public class FindPositionOfElementInInfiniteSortedArray {

	public static void main(String[] args) {

		int ar[] = { 1, 2, 3, 4, 5 }; // suppose it is infinite array.

		// problem is that we don't have a size of array.
		int l = 0;
		int h = 1;
		int key = 7;
		while (key > ar[h]) {
			l = h;
			h = h * 2;
		}

		binarySearch(ar, l, h, key);

	}

	private static int binarySearch(int[] ar, int l, int h, int key) {

		int mid = 0;
		while (l <= h) {
			mid = l + (h - l) / 2;
			if (ar[mid] == key) {
				return mid;
			} else if (ar[mid] < key) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;

	}

}
