package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given a string(str) and a number K.
2. You have to find length of the longest substring that has exactly k unique characters.
3. If no such substring exists, print "-1".
 */
public class LongestSubstringWithExactlyKUniqueCharacters {

	public static int solution(String str, int k) {

		HashMap<Character, Integer> map = new HashMap<>();

		int ans = -1;

		int i = 0;
		int j = -1;

		while (i < str.length()) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() == k) {
				int nlen = i - j;
				ans = Math.max(ans, nlen);
			}

			if (map.size() > k) {
				while (true) {

					char c = str.charAt(j + 1);
					int val = map.get(c);

					if (val > 1) {
						map.put(c, val - 1);
					} else {
						map.remove(c);
					}

					j++;

					if (map.size() == k) {
						break;
					}

				}
			}

			i++;

		}

		return ans;
	}

}
