package com.ds.level2.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

//916. Word Subsets

public class WordSubsets {

	public List<String> wordSubsets(String[] A, String[] B) {

		List<String> res = new ArrayList<>();

		int[] target = new int[26];

		// making common string out of all string.
		for (String b : B) {

			int[] temp = new int[26];
			for (char c : b.toCharArray()) {
				temp[c - 'a']++;
				target[c - 'a'] = Math.max(target[c - 'a'], temp[c - 'a']);
			}

		}

		for (String a : A) {

			int[] temp = new int[26];
			for (char c : a.toCharArray()) {
				temp[c - 'a']++;
			}

			if (subset(temp, target)) {
				res.add(a);
			}

		}

		return res;

	}

	public boolean subset(int[] tar, int[] sub) {

		for (int i = 0; i < 26; i++) {
			if (sub[i] > tar[i]) {
				return false;
			}
		}

		return true;

	}

}
