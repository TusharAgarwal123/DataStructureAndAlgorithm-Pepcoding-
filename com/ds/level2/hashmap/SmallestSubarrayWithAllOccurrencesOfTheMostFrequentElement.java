package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given an array(arr) of integers.
2. You have to find the element(x) with maximum frequency in the given array. 
3. Also, you have to find the smallest subarray which has all occurrences of the most frequent element i.e x.

Note -> If there are two or more elements with maximum frequency and the same subarray size then print the subarray
 which occurs first in the given array.
 */
public class SmallestSubarrayWithAllOccurrencesOfTheMostFrequentElement {

	public static void solution(int[] nums) {
		HashMap<Integer, Pair> map = new HashMap<>();

		int mfc = nums[0]; // most frequent element
		int mf = 1; // frequency of most frequent element
		int mlen = 1; // length of subarray that contains all occurances of most frequent element.

		map.put(nums[0], new Pair(1, 0, 0));

		for (int i = 1; i < nums.length; i++) {

			if (map.containsKey(nums[i])) {

				int val = nums[i];
				Pair p = map.get(val);

				p.freq++;
				p.li = i;

				int len = (i - p.si + 1);

				if (p.freq > mf) {
					mfc = val;
					mf = p.freq;
					mlen = len;

				} else if (p.freq == mf && len < mlen) {
					mfc = val;
					mf = p.freq;
					mlen = len;
				}

			} else {
				map.put(nums[i], new Pair(1, i, i));
			}

		}

		Pair pp = map.get(mfc);
		System.out.println(mfc);
		System.out.println(pp.si);
		System.out.println(pp.li);

	}

	static class Pair {
		int freq;
		int si;
		int li;

		Pair(int x, int y, int z) {
			freq = x;
			si = y;
			li = z;
		}
	}

}
