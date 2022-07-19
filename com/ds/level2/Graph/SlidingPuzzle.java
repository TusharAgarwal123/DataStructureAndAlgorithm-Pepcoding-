package com.ds.level2.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//773. Sliding Puzzle

/*
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0. 
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.

The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].

Given the puzzle board board, return the least number of moves required so that the state of the board is 
solved. If it is impossible for the state of the board to be solved, return -1.


 */

public class SlidingPuzzle {

	static class Pair {
		String config;
		int level;
	}

	public int slidingPuzzle(int[][] board) {

		HashSet<String> vis = new HashSet<>();

		Queue<Pair> q = new LinkedList<>();

		Pair root = new Pair();
		root.config = getConfig(board);
		root.level = 0;

		q.add(root);

		while (q.size() > 0) {

			Pair rem = q.remove();

			if (vis.contains(rem.config)) {
				continue;
			}
			vis.add(rem.config);

			if (rem.config.equals("123450")) {
				return rem.level; // level is denoting the no of swaps.
			}

			int dir[][] = { { 1, 3 }, { 0, 4, 2 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };

			int OthIndex = rem.config.indexOf('0');

			for (int i : dir[OthIndex]) {
				String nConfig = swap(rem.config, OthIndex, i);
				if (vis.contains(nConfig) == false) {
					Pair np = new Pair();
					np.config = nConfig;
					np.level = rem.level + 1;
					q.add(np);
				}
			}

		}

		return -1;

	}

	public String swap(String str, int i, int j) {

		StringBuilder sb = new StringBuilder(str);

		char chi = sb.charAt(i);
		char chj = sb.charAt(j);

		sb.setCharAt(i, chj);
		sb.setCharAt(j, chi);

		return sb.toString();

	}

	public String getConfig(int board[][]) {

		StringBuilder sb = new StringBuilder();

		for (int row[] : board) {
			for (int r : row) {
				sb.append(r);
			}
		}

		return sb.toString();

	}

}
