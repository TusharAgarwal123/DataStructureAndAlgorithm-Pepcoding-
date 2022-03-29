package com.ds.level2.hashmap;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagrams {

	// O(n*s)
	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
		// write your code here

		HashMap<HashMap<Character, Integer>, ArrayList<String>> omap = new HashMap<>();

		for (String str : strs) {

			HashMap<Character, Integer> map = new HashMap<>();
			for (char ch : str.toCharArray()) {
				map.put(ch, map.getOrDefault(ch, 0) + 1);
			}

			if (omap.containsKey(map)) {
				ArrayList<String> list = omap.get(map);
				list.add(str);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				omap.put(map, list);
			}

		}

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		for (ArrayList<String> ll : omap.values()) {
			ans.add(ll);
		}

		return ans;

	}

	// another approach
	public static ArrayList<ArrayList<String>> groupAnagrams2(String[] strs) {
		// write your code here

		HashMap<String, ArrayList<String>> omap = new HashMap<>();

		for (String str : strs) {

			String ss = getCode(str);

			if (omap.containsKey(ss)) {
				omap.get(ss).add(str);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(str);
				omap.put(ss, list);
			}

		}

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		for (ArrayList<String> ll : omap.values()) {
			ans.add(ll);
		}

		return ans;

	}

	public static String getCode(String s) {

		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		String code = "";
		for (char ch : map.keySet()) {
			code += ch + "" + map.get(ch);
		}

		return code;

	}

}
