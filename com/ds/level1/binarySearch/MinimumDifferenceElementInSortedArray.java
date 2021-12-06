package com.ds.level1.binarySearch;

public class MinimumDifferenceElementInSortedArray {

	/*
	 * in this array you have given an array and an element ,you have to find the
	 * minimum difference element,minimum difference element will be after
	 * substracting the given element with each element of array ,which element
	 * gives the minimum difference we have to print that. if same key is present in
	 * array then just return the key.
	 * 
	 * since array is sorted ,so minimum difference element will ocuur left nearest
	 * or rigth nearest to element.
	 * 
	 * like we have array =[1,3,8,10,15] and ele=12. so min difference element will
	 * either 10 and 15.
	 * 
	 * to find that you can find the floor and ceil of element and compare that
	 * which gives the minimum difference element.
	 * 
	 * but you also need not to do that just apply simple binary search.
	 * 
	 */

	public static void main(String[] args) {

		int ar[] = { 1, 3, 8, 9, 10, 15 };
		int l = 0;
		int r = ar.length - 1;
		int ele = 14;

		System.out.println(find(ar, l, r, ele));

	}

	static int find(int[] ar, int l, int r, int ele) {

		int mid = 0;
		while (l <= r) {
			mid = l + (r - l) / 2;
			if (ar[mid] == ele) {
				return ele;
			} else if (ar[mid] > ele) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		if (Math.abs(ar[l] - ele) < Math.abs(ar[r] - ele)) {
			return ar[l];
		} else {
			return ar[r];
		}

	}

}
