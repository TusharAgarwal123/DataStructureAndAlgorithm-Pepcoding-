package com.ds.level2.ArrayAndString;

//1392. Longest Happy Prefix

/*
 *A String is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.
 */

public class LongestHappyPrefix {

	public String longestPrefix(String s) {

		int[] lps = new int[s.length()];

		int len = 0;
		int i = 1;

		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(len)) {
				lps[i] = len + 1;
				len++;
				i++;
			} else if (len == 0) {
				lps[i] = 0;
				i++;
			} else {
				len = lps[len - 1];
			}

		}

		int k = lps[s.length() - 1]; // finding lps of last point.

		return s.substring(0, k);

	}

}
