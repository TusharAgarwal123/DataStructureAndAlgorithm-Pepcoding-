package com.ds.level1.sorting;

import java.util.Arrays;

public class MergeTwoSortedArray {

	public static void main(String[] args) {

		int a[] = { 10, 20, 30, 40 };
		int b[] = { 11, 15, 22, 25 };

		int ans[] = merge(a, b);
		System.out.println(Arrays.toString(ans));

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
