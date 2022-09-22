package com.ds.level1.Trie;

//208. Implement Trie (Prefix Tree)

/*
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and 
 * retrieve keys in a dataset of strings. There are various applications of this data structure, such 
 * as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before),
 and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the
 prefix prefix, and false otherwise.

 */

public class ImplementTriePrefixTree {

	static class Node {
		boolean eow = false;
		Node[] children = new Node[26];

	}

	Node root;

	public ImplementTriePrefixTree() {
		root = new Node();
	}

	public void insert(String word) {
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

		Node temp = root;

		for (char ch : word.toCharArray()) {
			if (temp.children[ch - 'a'] == null) {
				return false;
			}
			temp = temp.children[ch - 'a'];
		}

		return temp.eow;

	}

	public boolean startsWith(String prefix) {

		Node temp = root;

		for (char ch : prefix.toCharArray()) {
			if (temp.children[ch - 'a'] == null) {
				return false;
			}
			temp = temp.children[ch - 'a'];
		}

		return true;

	}

}
