package com.ds.level2.Graph;

import java.util.HashMap;
import java.util.Map;

//leetocode 839. Similar String Groups

/*
 * Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it
 *  equals Y. Also two strings X and Y are similar if they are equal.

For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar,
 but "star" is not similar to "tars", "rats", or "arts".

Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that
 "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that
  a word is in the group if and only if it is similar to at least one other word in the group.

We are given a list strs of strings where every string in strs is an anagram of every other string in strs. 
How many groups are there?


 */

public class SimilarStringGroups {

	Map<String, String> parent;
	Map<String, Integer> rank;

	public int numSimilarGroups(String[] strs) {

		parent = new HashMap<>();
		rank = new HashMap<>();

		for (String s : strs) {
			parent.put(s, s);
			rank.put(s, 0);

		}

		for (int i = 0; i < strs.length; i++) {
			for (int j = i + 1; j < strs.length; j++) {
				String si = strs[i];
				String sj = strs[j];

				if (areSimilar(si, sj)) {
					String sil = find(si);
					String sjl = find(sj);

					if (sil.equals(sjl) == false) {
						union(sil, sjl);
					}
				}
			}
		}

		int ans = 0;
		for (String ss : parent.keySet()) {
			if (parent.get(ss).equals(ss)) {
				ans++;
			}
		}

		return ans;

	}

	public boolean areSimilar(String x, String y) {

		int i = 0;
		int unEqual = 0;

		while (i < x.length()) {
			if (x.charAt(i) != y.charAt(i)) {
				unEqual++;
			}
			i++;
		}

		return (unEqual == 2);

	}

	public String find(String s) {
		if (parent.get(s).equals(s)) {
			return s;
		} else {
			String ps = parent.get(s);
			String psl = find(ps);
			parent.put(s, psl);
			return psl;
		}
	}

	public void union(String x, String y) {
		if (rank.get(x) < rank.get(y)) {
			parent.put(x, y);
		} else if (rank.get(y) < rank.get(x)) {
			parent.put(y, x);
		} else {
			parent.put(x, y);
			rank.put(y, rank.get(y) + 1);
		}
	}

}
