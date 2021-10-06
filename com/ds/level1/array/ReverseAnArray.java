package com.ds.level1.array;

public class ReverseAnArray {

	public static void main(String[] args) {

	}

	public static void reverse(int[] a) {
		// write your code here

		int l = 0;
		int r = a.length - 1;
		while (l <= r) {
			int t = a[l];
			a[l] = a[r];
			a[r] = t;
			l++;
			r--;
		}
	}

}
