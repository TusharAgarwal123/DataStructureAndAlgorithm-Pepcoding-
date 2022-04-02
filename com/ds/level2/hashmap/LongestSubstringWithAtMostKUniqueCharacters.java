package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given a string(str) and a number K.
2. You have to find the length of longest substring of the given string
 that contains at most K unique characters.
 */
public class LongestSubstringWithAtMostKUniqueCharacters {

	// O(n)
	public static int solution(String str, int k) {
		// write your code here

		int i = 0;
		int j = -1;
		int ans = 0;

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
