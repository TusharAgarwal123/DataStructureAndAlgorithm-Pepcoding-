package com.ds.level1.Trie;

//677. Map Sum Pairs

/*
 * Design a map that allows you to do the following:

Maps a string key to a given value.
Returns the sum of the values that have a key with a prefix equal to a given string.
Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed,
 the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.

 */

public class MapSumPairs {

	static class Node {
		boolean eow = false;
		Node[] children = new Node[26];
		int val = 0;
	}

	Node root;

	public MapSumPairs() {
		root = new Node();
	}

	public void insert(String key, int val) {

		Node temp = root;

		for (char ch : key.toCharArray()) {
			if (temp.children[ch - 'a'] == null) {
				temp.children[ch - 'a'] = new Node();
			}
			temp = temp.children[ch - 'a'];
		}

		temp.val = val;
		temp.eow = true;

	}

	int sum;

	public int sum(String prefix) {

		Node temp = root;

		for (char ch : prefix.toCharArray()) {
			if (temp.children[ch - 'a'] == null) {
				return 0;
			}
			temp = temp.children[ch - 'a'];
		}

		sum = 0;
		helper(temp);
		return sum;

	}

	public void helper(Node temp) {
		sum += temp.val;
		for (Node child : temp.children) {
			if (child != null) {
				helper(child);
			}
		}
	}

}
