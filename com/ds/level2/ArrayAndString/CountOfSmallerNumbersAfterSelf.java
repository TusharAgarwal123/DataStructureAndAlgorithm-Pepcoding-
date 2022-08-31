package com.ds.level2.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

//315. Count of Smaller Numbers After Self

/*
 * Given an integer array nums, return an integer array counts where counts[i] is the number of smaller
 *  elements to the right of nums[i].
 */

public class CountOfSmallerNumbersAfterSelf {

	int[] ans;

	static class Pair {
		int idx;
		int val;

		Pair(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
	}

	public List<Integer> countSmaller(int[] nums) {

		Pair[] pair = new Pair[nums.length];

		for (int i = 0; i < nums.length; i++) {
			pair[i] = new Pair(i, nums[i]);
		}

		ans = new int[nums.length];

		mergeSort(pair, 0, nums.length - 1);

		List<Integer> list = new ArrayList<>();
		for (int val : ans) {
			list.add(val);
		}

		return list;

	}

	public Pair[] mergeSort(Pair[] ar, int l, int hi) {

		if (l == hi) {
			Pair[] b = new Pair[1];
			b[0] = ar[l];
			return b;
		}

		int mid = (l + hi) / 2;

		Pair[] f = mergeSort(ar, l, mid);
		Pair[] s = mergeSort(ar, mid + 1, hi);

		Pair[] sor = mergeArrays(f, s);

		return sor;
	}

	public Pair[] mergeArrays(Pair[] f, Pair[] s) {

		Pair[] res = new Pair[f.length + s.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < f.length && j < s.length) {

			if (f[i].val > s[j].val) {
				ans[f[i].idx] += (s.length - j);
				res[k] = f[i];
				i++;
				k++;
			} else {
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
