package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given a string.
2. You have to find the count of valid substrings of the given string.
3. Valid substring is defined as a substring that has all unique characters.
 */
public class CountOfSubstringsHavingAllUniqueCharacters {

	public static int solution(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		int i = 0;
		int j = -1;

		int c = 0;
		while (i < str.length()) {

			char ch = str.charAt(i);
			if (map.containsKey(ch)) {
				while (true) {
					char cc = str.charAt(j + 1);
					map.remove(cc);
					j++;
					if (cc == ch) {
						break;
					}
				}
			} else {
				map.put(ch, 1);
				c += i - j;
				i++;
			}
		}

		return c;
	}

}
