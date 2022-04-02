package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 1. You are given an array of strings.
2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other. 
3. Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Note -> Every string consists of lower-case English letters only.
 */
public class GroupShiftedString {

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		// write your code here

		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for (String str : strs) {
			String code = getCode(str);

			if (map.containsKey(code)) {
				ArrayList<String> list = map.get(code);
				list.add(str);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				map.put(code, list);
			}

		}

		ArrayList<ArrayList<String>> list = new ArrayList<>();
		for (String code : map.keySet()) {
			list.add(map.get(code));
		}

		return list;
	}

	public static String getCode(String s) {

		String code = "";
		for (int i = 1; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i - 1);

			int diff = c1 - c2;
			if (diff < 0) {
				diff += 26;
			}

			code += diff + "*";
		}

		return code;

	}

}
