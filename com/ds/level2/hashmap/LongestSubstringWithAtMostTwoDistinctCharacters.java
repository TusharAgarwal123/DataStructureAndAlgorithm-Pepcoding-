package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static int lengthOfLongestSubstringTwoDistinct(String str) {

		int i = 0;
		int j = -1;
		int ans = 0;

		int k = 2;

		HashMap<Character, Integer> map = new HashMap<>();

		while (i < str.length()) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() <= k) {
				int nLen = i - j;
				ans = Math.max(ans, nLen);
			} else {
				while (true) {
					char cc = str.charAt(j + 1);
					int val = map.get(cc);
					if (val > 1) {
						map.put(cc, map.getOrDefault(cc, 0) - 1);
					} else {
						map.remove(cc);
					}
					j++;
					if (map.size() <= k) {
						break;
					}
				}
			}

			i++;
		}

		return ans;

	}

}
