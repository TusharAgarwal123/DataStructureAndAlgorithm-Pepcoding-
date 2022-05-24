package com.ds.leetcode.may;

import java.util.LinkedList;
import java.util.Queue;

//1091. Shortest Path in Binary Matrix
public class ShortestPathInBinaryMatrix {

	int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 0 }, { -1, 1 }, { -1, -1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;
		if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1) {
			return -1;
		}

		boolean visited[][] = new boolean[row][col];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });

		visited[0][0] = true;

		int c = 0;

		while (q.size() > 0) {
			int sz = q.size();
			for (int i = 0; i < sz; i++) {
				int[] poll = q.remove();
				if (poll[0] == row - 1 && poll[1] == col - 1) {
					return c + 1;
				}

				for (int[] dir : directions) {
					int x = dir[0] + poll[0];
					int y = dir[1] + poll[1];

					if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 0 && !visited[x][y]) {
						q.add(new int[] { x, y });
						visited[x][y] = true;
					}
				}
			}
			c++;
		}

		return -1;

	}
}
