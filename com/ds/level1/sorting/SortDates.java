package com.ds.level1.sorting;

import java.util.Scanner;

public class SortDates {

	/*
	 * 1. You are given an array(arr) of different dates in format DD-MM-YYYY. 2.
	 * You have to sort these dates in increasing order.
	 */

	public static void sortDates(String[] arr) {
		// write your code here

		countSort(arr, 1000000, 100, 32); // sorting dates
		countSort(arr, 10000, 100, 13); // sorting month
		countSort(arr, 1, 10000, 2501); // sorting year

	}

	public static void countSort(String[] arr, int div, int mod, int range) {
		// write your code here

		int n = arr.length;
		int fr[] = new int[range];
		String ans[] = new String[n];

		for (int i = 0; i < n; i++) {

			int val = Integer.parseInt(arr[i]) / div % mod;
			fr[val]++;

		}

		for (int i = 1; i < fr.length; i++) {

			fr[i] = fr[i] + fr[i - 1];

		}

		for (int i = n - 1; i >= 0; i--) {

			int val = Integer.parseInt(arr[i]) / div % mod;
			int pos = fr[val];
			ans[pos - 1] = arr[i];
			fr[val]--;

		}

		for (int i = 0; i < n; i++) {
			arr[i] = ans[i];
		}

	}

	public static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			arr[i] = str;
		}
		sortDates(arr);
		print(arr);
	}

}
