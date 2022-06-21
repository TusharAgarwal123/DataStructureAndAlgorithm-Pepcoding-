package com.ds.level2.Graph;

import java.util.LinkedList;
import java.util.Queue;

//934. Shortest Bridge
public class ShortestBridge {

	static class Pair {
		int x;
		int y;
		int level;

		Pair(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}
	}

	Queue<Pair> q = null;

	int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int shortestBridge(int[][] grid) {

		q = new LinkedList<>();

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		boolean found = false;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					found = true;
					traverse(grid, visited, i, j);
					break;
				}
			}
			if (found) {
				break;
			}
		}

		// first we have added the first island cells in queue then applied the BFS on
		// these points,
		// when ever we encounter 1st 1 which is unvisited or ot part of first island so
		// we will return
		// it's level.

		boolean vis[][] = new boolean[grid.length][grid[0].length];

		while (q.size() > 0) {

			Pair rem = q.remove();
			if (vis[rem.x][rem.y]) {
				continue;
			}

			vis[rem.x][rem.y] = true;

			if (grid[rem.x][rem.y] == 1 && visited[rem.x][rem.y] == false) {
				return rem.level - 1; // 1001 , here on level we will have 3 but answer should be 2.
			}

			for (int dr[] : dir) {
				int nx = dr[0] + rem.x;
				int ny = dr[1] + rem.y;

				addNeighBors(visited, nx, ny, q, rem.level);
			}

		}

		return -1;

	}

	public void addNeighBors(boolean visited[][], int i, int j, Queue<Pair> q, int level) {

		if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j]) {
			return;
		}

		q.add(new Pair(i, j, level + 1));

	}

	public void traverse(int[][] grid, boolean visited[][], int i, int j) {

		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
			return;
		}

		visited[i][j] = true;
		q.add(new Pair(i, j, 0));

		for (int dr[] : dir) {
			int ni = dr[0] + i;
			int nj = dr[1] + j;
			traverse(grid, visited, ni, nj);
		}

	}

}
