package com.ds.level2.ArrayAndString;

//on gfg

/*
 * Given an array of integers. Find the Inversion Count in the array. 

Inversion Count: For an array, inversion count indicates how far (or close) the array 
is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in
 the reverse order then the inversion count is the maximum. 
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 */

public class CountInversions {

	static long ans = 0;

	static long inversionCount(long arr[], long N) {
		// Your Code Here

		ans = 0;
		mergeSort(arr, 0, arr.length - 1);
		return ans;

	}

	static long[] mergeSort(long[] ar, int l, int hi) {

		if (l == hi) {
			long[] b = new long[1];
			b[0] = ar[l];
			return b;
		}

		int mid = (l + hi) / 2;

		long[] f = mergeSort(ar, l, mid);
		long[] s = mergeSort(ar, mid + 1, hi);

		long[] sor = mergeArrays(f, s);

		return sor;
	}

	static long[] mergeArrays(long[] f, long[] s) {

		long[] res = new long[f.length + s.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < f.length && j < s.length) {

			if (f[i] <= s[j]) {
				res[k] = f[i];
				i++;
				k++;
			} else {
				ans += (f.length - i); // finding inversions.
				res[k] = s[j];
				j++;
				k++;
			}

		}

		while (i < f.length) {
			res[k] = f[i];
			i++;
			k++;
		}

		while (j < s.length) {
			res[k] = s[j];
			j++;
			k++;
		}

		return res;

	}

}
