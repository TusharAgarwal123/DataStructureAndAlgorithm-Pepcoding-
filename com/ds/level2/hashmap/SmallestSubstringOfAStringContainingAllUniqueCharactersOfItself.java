package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class SmallestSubstringOfAStringContainingAllUniqueCharactersOfItself {

	/*
	 * 1. You are given a string str. 2. You have to find the smallest window length
	 * that contains all the unique characters of the given string.
	 * 
	 */

	// O(n)
	public static int solution(String str) {

		HashMap<Character, Integer> map = new HashMap<>();
		HashSet<Character> set = new HashSet<>();

		for (char ch : str.toCharArray()) {
			set.add(ch);
		}

		int ans = Integer.MAX_VALUE;

		int i = 0;
		int j = -1;

		while (i < str.length()) {
			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			if (map.size() == set.size()) {
				while (true) {

					int nlen = i - j;
					ans = Math.min(ans, nlen);

					char c = str.charAt(j + 1);
					int val = map.get(c);

					if (val > 1) {
						map.put(c, val - 1);
					} else {
						map.remove(c);
					}

					j++;

					if (map.size() < set.size()) {
						break;
					}

				}
			}

			i++;

		}

		return ans;
	}

}
