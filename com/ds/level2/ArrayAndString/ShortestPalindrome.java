package com.ds.level2.ArrayAndString;

//214. Shortest Palindrome

/*
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.


 */

public class ShortestPalindrome {

	public String shortestPalindrome(String s) {

		String s1 = s + "$" + new StringBuilder(s).reverse().toString();

		int[] lps = new int[s1.length()];
		int len = 0;
		int i = 1;
		while (i < s1.length()) {
			if (s1.charAt(i) == s1.charAt(len)) {
				lps[i] = len + 1;
				len++;
				i++;
			} else if (len > 0) {
				len = lps[len - 1];
			} else {
				lps[i] = 0;
				i++;
			}
		}

		int pool = lps[lps.length - 1];
		String right = s.substring(pool);

		return new StringBuilder(right).reverse().toString() + s;

	}

}
