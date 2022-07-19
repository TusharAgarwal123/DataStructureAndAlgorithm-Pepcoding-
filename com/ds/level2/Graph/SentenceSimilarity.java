package com.ds.level2.Graph;

import java.util.HashMap;

/*
 * Given two sentences sentence1 and sentence2 each represented as a string array and given a 2d array of 
 * string pairs where each row contains two words {x,y} indicating that the word x and y are similar.
Return true if sentence1 and sentence2 are similar, or false if they are not similar. Two sentences are similar 
if they have the same length and sentence1[i] and sentences2[i] are similar.

Note: Similarity relation is transitive.
 */

public class SentenceSimilarity {

	static HashMap<String, String> parent;
	static HashMap<String, Integer> rank;

	public static boolean areSentencesSimilarTwo(String[] Sentence1, String[] Sentence2, String[][] pairs) {

		if (Sentence1.length != Sentence2.length) {
			return false;
		}

		parent = new HashMap<>();
		rank = new HashMap<>();

		for (int i = 0; i < pairs.length; i++) {
			if (!parent.containsKey(pairs[i][0])) {
				parent.put(pairs[i][0], pairs[i][0]);
				rank.put(pairs[i][0], 0);
			}

			if (!parent.containsKey(pairs[i][1])) {
				parent.put(pairs[i][1], pairs[i][1]);
				rank.put(pairs[i][1], 0);
			}
		}

		for (int i = 0; i < pairs.length; i++) {

			String p1 = find(pairs[i][0]);
			String p2 = find(pairs[i][1]);

			if (p1.equals(p2) == false) {
				union(p1, p2);
			}

		}

		for (int i = 0; i < Sentence1.length; i++) {
			String w1 = Sentence1[i];
			String w2 = Sentence2[i];

			if (w1.equals(w2)) {
				continue;
			} else if (parent.containsKey(w1) == false || parent.containsKey(w2) == false) {
				return false;
			}

			String w1Lead = find(w1);
			String w2Lead = find(w2);

			if (w1Lead.equals(w2Lead) == false) {
				return false;
			}

		}

		return true;

	}

	public static String find(String x) {
		if (parent.get(x).equals(x)) {
			return x;
		} else {
			String pos = parent.get(x);
			String lead = find(pos);
			parent.put(x, lead);
			return lead;
		}
	}

	public static void union(String x, String y) {
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
