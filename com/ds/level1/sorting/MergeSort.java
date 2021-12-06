package com.ds.level1.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int ar[] = { 56, 12, 34, 98, 5, 7, 28 };
		int low = 0;
		int high = ar.length - 1;

		int sorted[] = mergeSort(ar, low, high);

		System.out.println(Arrays.toString(sorted));

	}

	public static int[] mergeSort(int ar[], int low, int high) {

		if (low == high) {
			int br[] = new int[1];
			br[0] = ar[low];
			return br;
		}

		int mid = low + (high - low) / 2;

		int first[] = mergeSort(ar, low, mid);
		int second[] = mergeSort(ar, mid + 1, high);

		int sorted[] = merge(first, second);

		return sorted;

	}

	public static int[] merge(int f[], int s[]) {

		int sorted[] = new int[f.length + s.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < f.length && j < s.length) {

			if (f[i] < s[j]) {
				sorted[k] = f[i];
				i++;
				k++;
			} else {
				sorted[k] = s[j];
				j++;
				k++;
			}

		}

		while (i < f.length) {
			sorted[k] = f[i];
			i++;
			k++;
		}
		while (j < s.length) {
			sorted[k] = s[j];
			j++;
			k++;
		}
		return sorted;

	}

}
