package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * 1. You are given two strings s1, s2, and a number K.
2. You have to find if two strings are K-anagrams of each other or not.
3. Two strings are called K-anagrams if 
   -> Both s1 and s2 have the same number of characters.
   -> After changing K characters in any string, s1 and s2 become anagram of each other. 

Note -> Both s1 ad s2 consist of lowercase English letters only.
 */
public class KAnagrams {

	public static boolean areKAnagrams(String str1, String str2, int k) {
		// write your code here

		if (str1.length() != str2.length()) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : str1.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int c = 0;
		for (char ch : str2.toCharArray()) {
			if (map.containsKey(ch)) {
				if (map.get(ch) > 1) {
					map.put(ch, map.get(ch) - 1);
				} else {
					map.remove(ch);
				}

			} else {
				// counting how many characters are left.
				c++;
			}
		}

		// counting how many characters are left.
// 		int sum=0;
// 		for(char ch:map.keySet()){
// 		    sum+=map.get(ch);
// 		}

		if (c <= k) {
			return true;
		}

		return false;
	}

}
