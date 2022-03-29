package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.
 */
public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {

		if (s.length() < t.length()) {
			return "";
		}

		HashMap<Character, Integer> tmap = new HashMap<>();
		for (char ch : t.toCharArray()) {
			tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
		}

		int count = t.length();

		int i = 0;
		int j = -1;

		HashMap<Character, Integer> smap = new HashMap<>();

		String ans = "";

		while (i < s.length()) {

			char ch = s.charAt(i);
			smap.put(ch, smap.getOrDefault(ch, 0) + 1);

			if (smap.get(ch) <= tmap.getOrDefault(ch, 0)) {
				count--;
			}

			if (count == 0) {
				while (true) {
					String nAns = s.substring(j + 1, i + 1);
					if (ans.length() == 0) {
						ans = nAns;
					} else if (nAns.length() < ans.length()) {
						ans = nAns;
					}

					char cc = s.charAt(j + 1);
					if (smap.get(cc) > 1) {
						smap.put(cc, smap.getOrDefault(cc, 0) - 1);
					} else {
						smap.remove(cc);
					}

					if (smap.getOrDefault(cc, 0) < tmap.getOrDefault(cc, 0)) {
						count++;
					}

					j++;

					if (count > 0) {
						break;
					}
				}
			}

			i++;

		}

		return ans;

	}

}
