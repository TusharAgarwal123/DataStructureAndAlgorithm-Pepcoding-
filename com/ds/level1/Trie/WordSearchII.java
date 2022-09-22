package com.ds.level1.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//212. Word Search II

/*
 * Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are 
horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 
 */

public class WordSearchII {

	static class Node {
		boolean eow = false;
		Node[] children = new Node[26];

	}

	Node root = new Node();

	public List<String> findWords(char[][] board, String[] words) {

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

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				helper(board, visited, i, j, new StringBuilder(), root);

			}
		}

		return new ArrayList<String>(set);

	}

	int[][] dirs = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
	HashSet<String> set = new HashSet<>();

	public void helper(char[][] board, boolean[][] visited, int i, int j, StringBuilder sb, Node node) {

		char ch = board[i][j];
		sb.append(ch);

		if (node.children[ch - 'a'] == null) {
			sb.deleteCharAt(sb.length() - 1);
			return;
		}

		Node child = node.children[ch - 'a'];

		if (child.eow) {
			set.add(sb.toString());
		}

		visited[i][j] = true;

		for (int[] dir : dirs) {
			int ii = i + dir[0];
			int jj = j + dir[1];

			if (ii >= 0 && ii < board.length && jj >= 0 && jj < board[0].length && visited[ii][jj] == false) {
				helper(board, visited, ii, jj, sb, child);
			}
		}

		visited[i][j] = false;
		sb.deleteCharAt(sb.length() - 1);

	}

}
