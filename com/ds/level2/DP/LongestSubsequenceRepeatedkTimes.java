package com.ds.level2.DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//2014. Longest Subsequence Repeated k Times

/*
 * You are given a string s of length n, and an integer k. You are tasked to find the longest subsequence
 *  repeated k times in string s.

A subsequence is a string that can be derived from another string by deleting some or no characters without
 changing the order of the remaining characters.

A subsequence seq is repeated k times in the string s if seq * k is a subsequence of s, where seq * k
 represents a string constructed by concatenating seq k times.

For example, "bba" is repeated 2 times in the string "bababcba", because the string "bbabba", constructed by
 concatenating "bba" 2 times, is a subsequence of the string "bababcba".
Return the longest subsequence repeated k times in string s. If multiple such subsequences are found, return
 the lexicographically largest one. If there is no such subsequence, return an empty string.

 


 */

public class LongestSubsequenceRepeatedkTimes {

	public String longestSubsequenceRepeatedK(String s, int k) {

		int[] map = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map[ch - 'a']++;
		}

		List<Character> valid = new ArrayList<>();

		for (int i = 0; i < 26; i++) {
			if (map[i] >= k) {
				valid.add((char) ('a' + i));
			}
		}

		String ans = "";
		Queue<String> q = new LinkedList<>();
		q.add("");

		while (q.size() > 0) {
			String rem = q.remove();
			for (char ch : valid) {
				String next = rem + ch;
				if (isKSub(s, next, k)) {
					q.add(next);
					ans = next;
				}
			}
		}

		return ans;

	}

	public boolean isKSub(String s, String sub, int k) {
		int j = 0;
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == sub.charAt(j)) {
				j++;
				if (j == sub.length()) {
					count++;
					j = 0;
					if (count == k) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
