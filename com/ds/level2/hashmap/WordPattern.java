package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.HashSet;

/*
 * 1. You are given two strings S1 and S2. S1 represents a word of length N and S2 represents N space-separated words.
2. You have to find if the words in S2 follow the exact order as characters in S1.

Note -> Every string consists of lower-case English letters only.
 */
public class WordPattern {

	public boolean wordPattern(String pattern, String s) {

		String str[] = s.split(" ");

		if (pattern.length() != str.length) {
			return false;
		}

		HashMap<Character, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<>();

		int i = 0;
		while (i < pattern.length()) {
			char c1 = pattern.charAt(i);
			String c2 = str[i];

			if (!map.containsKey(c1)) {

				if (set.contains(c2)) {
					return false;
				}
				map.put(c1, c2);
				set.add(c2);
			} else {
				String c = map.get(c1);
				if (!c.equals(c2)) {
					return false;
				}
			}

			i++;
		}

		return true;

	}
}
