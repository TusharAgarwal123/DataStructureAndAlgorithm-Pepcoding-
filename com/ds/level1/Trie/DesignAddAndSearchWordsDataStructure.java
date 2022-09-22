package com.ds.level1.Trie;

//211. Design Add and Search Words Data Structure

/*
 * Design a data structure that supports adding new words and finding if a string matches any previously
 *  added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false
 otherwise. word may contain dots '.' where dots can be matched with any letter.

 */

public class DesignAddAndSearchWordsDataStructure {

	static class Node {
		boolean eow = false;
		Node[] children = new Node[26];

	}

	Node root;

	public DesignAddAndSearchWordsDataStructure() {
		root = new Node();
	}

	public void addWord(String word) {
		Node temp = root;

		for (char ch : word.toCharArray()) {
			if (temp.children[ch - 'a'] == null) {
				temp.children[ch - 'a'] = new Node();
			}
			temp = temp.children[ch - 'a'];
		}

		temp.eow = true;
	}

	public boolean search(String word) {
		return helper(word, 0, root);
	}

	public boolean helper(String word, int idx, Node node) {

		if (idx == word.length()) {
			return node.eow;
		}

		char ch = word.charAt(idx);

		if (ch != '.') {
			Node child = node.children[ch - 'a'];
			if (child == null) {
				return false;
			} else {
				return helper(word, idx + 1, child);
			}
		} else {
			for (char nch = 'a'; nch <= 'z'; nch++) {
				Node child = node.children[nch - 'a'];
				if (child != null) {
					boolean res = helper(word, idx + 1, child);
					if (res) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
