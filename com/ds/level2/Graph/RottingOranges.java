package com.ds.level2.Graph;

import java.util.LinkedList;
import java.util.Queue;

//994. Rotting Oranges
public class RottingOranges {

	static class Pair {
		int x;
		int y;
		int t;

		Pair(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	public int orangesRotting(int[][] grid) {

		Queue<Pair> q = new LinkedList<>();
		int fresh = 0;

		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[0].length; y++) {
				if (grid[x][y] == 2) {
					q.add(new Pair(x, y, 0));
				} else if (grid[x][y] == 1) {
					fresh++;
				}
			}
		}

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		int time = 0;
		while (q.size() > 0) {

			Pair rem = q.remove();

			if (visited[rem.x][rem.y]) {
				continue;
			}

			visited[rem.x][rem.y] = true;

			if (rem.t > time) {
				time = rem.t;
			}

			if (grid[rem.x][rem.y] == 1) {
				fresh--;
			}

			addNeighbors(rem.x + 1, rem.y, visited, grid, q, rem.t + 1);
			addNeighbors(rem.x - 1, rem.y, visited, grid, q, rem.t + 1);
			addNeighbors(rem.x, rem.y + 1, visited, grid, q, rem.t + 1);
			addNeighbors(rem.x, rem.y - 1, visited, grid, q, rem.t + 1);

		}

		if (fresh == 0) {
			return time;
		} else {
			return -1;
		}

	}

	public void addNeighbors(int x, int y, boolean visited[][], int[][] grid, Queue<Pair> q, int t) {

		if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y] == true || grid[x][y] == 0) {
			return;
		}

		q.add(new Pair(x, y, t));

	}

}
