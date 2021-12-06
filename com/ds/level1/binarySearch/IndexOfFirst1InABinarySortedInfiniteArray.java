package com.ds.level1.binarySearch;

public class IndexOfFirst1InABinarySortedInfiniteArray {

	/*
	 * we have binary sorted infinite array ,consisting of only 0 and 1. we have to
	 * find out the index of first 1.
	 */

	public static void main(String[] args) {

		int ar[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		int l = 0;
		int h = 1;

		while (ar[h] != 1) {
			l = h;
			h = h * 2;
		}

		System.out.println(find(ar, l, h, 1));

	}

	// this method finds the first occurence of 1.
	static int find(int[] ar, int l, int h, int i) {

		int mid = 0;
		int ans = -1;
		while (l <= h) {

			mid = l + (h - l) / 2;
			if (ar[mid] == i) {
				ans = mid;
				h = mid - 1;
			} else if (ar[mid] > i) {
				h = mid - 1;
			} else {
				l = mid + 1;
			}

		}
		return ans;

	}
}
