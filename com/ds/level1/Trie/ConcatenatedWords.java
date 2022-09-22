package com.ds.level1.Trie;

import java.util.ArrayList;
import java.util.List;

//472. Concatenated Words

/*
 * Given an array of strings words (without duplicates), return all the concatenated words in the given
 *  list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the
 given array.


 */

public class ConcatenatedWords {

	static class Node {
		boolean eow = false;
		Node[] children = new Node[26];

	}

	Node root = new Node();

	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		for (String word : words) {
			Node temp = root;
			for (char ch : word.toCharArray()) {
				if (temp.children[ch - 'a'] == null) {
					temp.children[ch - 'a'] = new Node();
				}

				temp = temp.children[ch - 'a'];
			}
			temp.eow = true;
		}

		List<String> res = new ArrayList<>();

		for (String word : words) {
			flag = false;
			isComplexWord(word, 0, 0);
			if (flag == true) {
				res.add(word);
			}
		}

		return res;

	}

	boolean flag = false;

	public void isComplexWord(String word, int i, int wsf) {

		if (i == word.length()) {
			if (wsf >= 2) {
				flag = true;
			}

			return;
		}

		Node temp = root;
		for (int j = i; j < word.length(); j++) {

			char ch = word.charAt(j);
			if (temp.children[ch - 'a'] != null) {
				temp = temp.children[ch - 'a'];

				if (temp.eow) {
					isComplexWord(word, j + 1, wsf + 1);
				}
			} else {
				return;
			}

		}

	}

}
