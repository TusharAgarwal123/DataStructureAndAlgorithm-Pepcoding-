package com.ds.level2.ArrayAndString;

import java.util.ArrayList;

//Search Pattern (KMP-Algorithm) on gfg.

/*
 * Given two strings, one is a text string, txt and other is a pattern string, pat. The task is to print the
 *  indexes of all the occurences of pattern string in the text string. For printing, Starting Index of a
 *   string should be taken as 1.

 */

public class SearchPattern_KMP_Algorithm {

	ArrayList<Integer> search(String pat, String txt) {
		int[] lps = getLPS(pat);

		ArrayList<Integer> list = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i < txt.length()) {
			if (txt.charAt(i) == pat.charAt(j)) {
				i++;
				j++;

				if (j == pat.length()) {
					list.add(i - j + 1);
					j = lps[j - 1];
				}
			} else if (j == 0) {
				i++;
			} else {
				j = lps[j - 1];
			}
		}

		return list;
	}

	public int[] getLPS(String pat) {

		int[] lps = new int[pat.length()];

		int len = 0;
		int i = 1;

		while (i < pat.length()) {
			if (pat.charAt(i) == pat.charAt(len)) {
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

		return lps;

	}

}
