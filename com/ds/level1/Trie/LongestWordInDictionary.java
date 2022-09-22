package com.ds.level1.Trie;

//720. Longest Word in Dictionary

/*
 * Given an array of strings words representing an English Dictionary, return the longest word in words that
 *  can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end
 of a previous word. 
 */

public class LongestWordInDictionary {

	static class Node {
		boolean eow = false;
		Node[] children = new Node[26];

	}

	String res = "";

	public String longestWord(String[] words) {

		Node root = new Node();

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

		helper(root, new StringBuilder());

		return res;

	}

	public void helper(Node node, StringBuilder wsf) {

		if (wsf.length() > res.length()) {
			res = wsf.toString();
		}

		for (char ch = 'a'; ch <= 'z'; ch++) {
			Node child = node.children[ch - 'a'];
			if (child != null && child.eow == true) {
				wsf.append(ch);
				helper(node, wsf);
				wsf.deleteCharAt(wsf.length() - 1);
			}
		}

	}

}
