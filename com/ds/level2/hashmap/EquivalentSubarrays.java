package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 1. You are given an array of integers(arr).
2. You have to find the count of equivalent subarrays.
3. A subarray is equivalent if,
   count of unique integers in the subarray = count of unique integers in the given array.
 */

//leetcode 992.
public class EquivalentSubarrays {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		// counting the unique element.
		HashSet<Integer> set = new HashSet<>();
		for (int x : arr) {
			set.add(x);
		}
		int k = set.size();

		// for counting subarray with exactly k unique character, you have to do like
		// that.

		int x1 = atMostK(arr, k);
		int x2 = atMostK(arr, k - 1);

		System.out.println(x1 - x2);

	}

	public static int atMostK(int ar[], int k) {
		int i = 0;
		int j = -1;
		int ans = 0;

		HashMap<Integer, Integer> map = new HashMap<>();

		while (i < ar.length) {
			int ch = ar[i];
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			if (map.size() <= k) {
				int nlen = i - j;
				ans += nlen;
			} else if (map.size() > k) {
				while (true) {
					int cc = ar[j + 1];
					int val = map.get(cc);
					if (val > 1) {
						map.put(cc, map.getOrDefault(cc, 0) - 1);
					} else {
						map.remove(cc);
					}
					j++;
					if (map.size() <= k) {
						int nlen = i - j;
						ans += nlen;
						break;
					}
				}
			}

			i++;
		}

		return ans;
	}

}
