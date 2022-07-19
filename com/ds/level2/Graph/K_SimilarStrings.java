package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//854. K-Similar Strings

/*
 * Strings s1 and s2 are k-similar (for some non-negative integer k) if we can swap the positions of two 
 * letters in s1 exactly k times so that the resulting string equals s2.

Given two anagrams s1 and s2, return the smallest k for which s1 and s2 are k-similar.

 


 */

public class K_SimilarStrings {

	public int kSimilarity(String s1, String s2) {

		HashSet<String> vis = new HashSet<>();

		Queue<String> q = new LinkedList<>();

		q.add(s1);

		int level = 0;

		while (q.size() > 0) {
			int sz = q.size();

			for (int i = 0; i < sz; i++) {
				String rem = q.remove();

				if (vis.contains(rem)) {
					continue;
				}

				vis.add(rem);

				if (rem.equals(s2)) {
					return level;
				}

				for (String s : getNeighbors(rem, s2)) {
					if (vis.contains(s) == false) {
						q.add(s);
					}
				}
			}

			level++;
		}

		return -1;

	}

	public ArrayList<String> getNeighbors(String rem, String s2) {

		ArrayList<String> res = new ArrayList<>();

		int idx = -1;
		for (int i = 0; i < rem.length(); i++) {
			if (rem.charAt(i) != s2.charAt(i)) {
				idx = i;
				break;
			}
		}

		for (int j = idx + 1; j < rem.length(); j++) {
			if (rem.charAt(j) == s2.charAt(idx)) {
				String ss = swap(rem, idx, j);
				res.add(ss);
			}
		}

		return res;

	}

	public String swap(String s, int i, int j) {

		StringBuilder sb = new StringBuilder(s);

		char chi = sb.charAt(i);
		char chj = sb.charAt(j);

		sb.setCharAt(i, chj);
		sb.setCharAt(j, chi);

		return sb.toString();

	}

}
