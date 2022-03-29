package com.ds.level2.hashmap;

import java.util.ArrayList;

/*
 * 1. You are given two strings s1 and s2.
2. You have to find the count of s2's anagrams that are present in s1.
3. Also, you have to print the start indices of such anagrams in s1.

Note -> Both s1 ad s2 consist of lowercase English letters only.
 */
public class FindAllAnagramsInAString {

	public static void findAnagrams(String s, String p) {
		// write your code here

		if (s.length() < p.length()) {
			return;
		}

		int map2[] = new int[26];
		for (int i = 0; i < p.length(); i++) {
			char ch = p.charAt(i);
			map2[ch - 'a']++;
		}

		int map1[] = new int[26];
		for (int i = 0; i < p.length(); i++) {
			char ch = s.charAt(i);
			map1[ch - 'a']++;
		}

		ArrayList<Integer> list = new ArrayList<>();

		if (areAnagrams(map1, map2)) {
			list.add(0);
		}

		int i = p.length();
		int j = 0;

		while (i < s.length()) {
			char chi = s.charAt(i);
			map1[chi - 'a']++;

			char chj = s.charAt(j);
			if (map1[chj - 'a'] > 0) {
				map1[chj - 'a']--;
			}

			if (areAnagrams(map1, map2)) {
				list.add(j + 1);
			}
			i++;
			j++;

		}

		System.out.println(list.size());
		for (int val : list) {
			System.out.print(val + " ");
		}

	}

	public static boolean areAnagrams(int map1[], int map2[]) {
		for (int i = 0; i < 26; i++) {
			if (map1[i] != map2[i]) {
				return false;
			}
		}
		return true;
	}

}
