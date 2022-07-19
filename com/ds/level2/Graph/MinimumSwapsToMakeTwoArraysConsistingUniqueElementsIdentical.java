package com.ds.level2.Graph;

import java.util.HashMap;

//on gfg

/*
 * Given two arrays that have the same values but in a different order and having no duplicate elements in it,
 *  we need to make a second array the same as a first array using the minimum number of swaps. 
 */

public class MinimumSwapsToMakeTwoArraysConsistingUniqueElementsIdentical {

	public static void main(String[] args) {

		int f[] = { 3, 6, 4, 8 };
		int s[] = { 4, 6, 8, 3 };

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length; i++) {
			map.put(s[i], i);
		}

		boolean vis[] = new boolean[f.length];
		int ans = 0;

		for (int i = 0; i < f.length; i++) {
			if (vis[i] == true || map.get(f[i]) == i) {
				continue;
			}

			vis[i] = true;
			int j = i;
			int cSize = 0; // cycle size.
			do {
				cSize++;
				j = map.get(f[j]);
				vis[j] = true;
			} while (j != i);

			ans += (cSize - 1);
		}

		System.out.println(ans);
	}
}
