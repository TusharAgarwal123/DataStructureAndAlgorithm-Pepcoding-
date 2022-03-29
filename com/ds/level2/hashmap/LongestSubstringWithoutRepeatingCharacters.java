package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Given a string s, find the length of the longest substring without repeating characters.
 */
//leetcode 3.
public class LongestSubstringWithoutRepeatingCharacters {

	// O(n)
	public int lengthOfLongestSubstring(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		int j = -1;
		int i = 0;

		int len = 0;

		while (i < s.length()) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				while (true) {
					char cc = s.charAt(j + 1);
					map.remove(cc);
					j++;
					if (cc == ch) {
						break;
					}
				}
			} else {
				map.put(ch, 1);
				int nLen = (i - j + 1) - 1;
				if (nLen > len) {
					len = nLen;
				}
				i++;
			}
		}

		return len;

	}

}
