package com.ds.level1.binarySearch;

public class CountOfAnElementInSortedArray {

	/*
	 * you have given an sorted array and element you have to count the occurence of
	 * element in an array.
	 *
	 * if array is sorted then all the occurence of element we want to search will
	 * be continous. so we will find the first and last occurence of element and 1
	 * to it.
	 */
	public static void main(String[] args) {

		int ar[] = { 2, 4, 6, 8, 8, 8, 9, 10 };
		int l = 0;
		int r = ar.length - 1;
		int ele = 8;

		int firstIndex = search(ar, l, r, ele);
		int lastIndex = search2(ar, l, r, ele);

		System.out.println(lastIndex - firstIndex + 1);

	}

	static int search(int[] ar, int l, int r, int ele) {

		int mid = 0;
		int res = -1;

		while (l <= r) {

			mid = l + (r - l) / 2;
			if (ar[mid] == ele) {
				res = mid;
				r = mid - 1;
			} else if (ar[mid] > ele) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return res;

	}

	static int search2(int[] ar, int l, int r, int ele) {

		int mid = 0;
		int res = -1;

		while (l <= r) {

			mid = l + (r - l) / 2;
			if (ar[mid] == ele) {
				res = mid;
				l = mid + 1;
			} else if (ar[mid] > ele) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

		}

		return res;

	}

}
