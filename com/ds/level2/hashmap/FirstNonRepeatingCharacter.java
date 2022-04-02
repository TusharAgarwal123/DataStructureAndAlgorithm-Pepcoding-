package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given a string.
2. You have to find the index of the first non-repeating character in the given string.
3. If no such character exists, print "-1".
 */
public class FirstNonRepeatingCharacter {

	public static int solution(String s) {

		HashMap<Character, Pair> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				Pair p = map.get(ch);
				p.freq++;
			} else {
				map.put(ch, new Pair(1, i));
			}
		}

		int ans = Integer.MAX_VALUE;

		for (char ch : map.keySet()) {

			Pair pp = map.get(ch);
			if (pp.freq == 1) {
				ans = Math.min(ans, pp.si);
			}

		}

		return (ans == Integer.MAX_VALUE ? -1 : ans);

	}

	static class Pair {
		int freq;
		int si;

		Pair(int x, int y) {
			freq = x;
			si = y;
		}
	}

}
