package com.ds.level1.Trie;

import java.util.List;

//648. Replace Words

/*
 * In English, we have a concept called root, which can be followed by some other word to form another longer 
 * word - let's call this word successor. For example, when the root "an" is followed by the successor word
 *  "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace
 all the successors in the sentence with the root forming it. If a successor can be replaced by more than
  one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.
 */

public class ReplaceWords {

	static class Node {
		boolean eow = false;
		Node[] children = new Node[26];

	}

	public String replaceWords(List<String> dictionary, String sentence) {

		Node root = new Node();

		for (String word : dictionary) {
			Node temp = root;
			for (char ch : word.toCharArray()) {
				if (temp.children[ch - 'a'] == null) {
					temp.children[ch - 'a'] = new Node();
				}

				temp = temp.children[ch - 'a'];
			}
			temp.eow = true;
		}

		String[] words = sentence.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];

			Node temp = root;
			for (int j = 0; j < word.length(); j++) {
				char ch = word.charAt(j);

				if (temp.children[ch - 'a'] == null) {
					break;
				} else {
					temp = temp.children[ch - 'a'];
					if (temp.eow) {
						words[i] = word.substring(0, j + 1);
						break;
					}
				}
			}
		}

		return String.join(" ", words);

	}

}
