package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.HashSet;

/*
 * 1. You are given two strings s1 and s2.
2. You have to determine if they are isomorphic or not.
3. Two strings are called isomorphic if -
   -> Every character of s1 can be mapped with characters of s2.
   -> A character of s1 can be mapped to only one character.
   -> All occurrences of a character must be replaced with another character while preserving the order of characters.

Note -> Length of s1 is equal to the length of s2.
 */
public class IsomorphicString {

	public boolean isIsomorphic(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Character> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();

		int i = 0;
		while (i < s.length()) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (!map.containsKey(c1)) {

				if (set.contains(c2)) {
					return false;
				}
				map.put(c1, c2);
				set.add(c2);
			} else {
				char c = map.get(c1);
				if (c2 != c) {
					return false;
				}
			}

			i++;
		}

		return true;

	}

}
