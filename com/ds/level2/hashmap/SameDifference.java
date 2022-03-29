package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * you have given an array a of n integer, count the number of pairs of indices (i,j)
 * such that i<j and (a[j]-a[i]=j-i)
 * 
 * we can convert given equation in (a[j]-j=a[i]-i)
 */
public class SameDifference {

	public static long countPairs(int ar[]) {

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < ar.length; i++) {
			int dif = ar[i] - i;
			map.put(dif, map.getOrDefault(dif, 0) + 1);
		}

		long ans = 0;
		for (int key : map.keySet()) {
			long freq = (long) map.get(key);
			long val = (freq * (freq - 1) / 2);
			ans += val;

		}

		return ans;

	}

}
