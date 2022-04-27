package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given two strings s1 and s2.
2. You have to determine if s2 is an anagram of s1.
 */
public class ValidAnagram {

	public static boolean solution(String s1, String s2) {
		// write your code here

		if (s1.length() != s2.length()) {
			return false;
		}

		int map1[] = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			map1[s1.charAt(i) - 'a']++;
		}

		int map2[] = new int[26];
		for (int i = 0; i < s2.length(); i++) {
			map2[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (map1[i] != map2[i]) {
				return false;
			}
		}

		return true;
	}

	// another approach
	public static boolean solution2(String s1, String s2) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for (int i = 0; i < s2.length(); i++) {
			char ch = s2.charAt(i);
			if (!map.containsKey(ch)) {
				return false;
			}
			map.put(ch, map.get(ch) - 1);
			if (map.get(ch) < 1) {
				map.remove(ch);
			}
		}
		return map.size() == 0;
	}

}
