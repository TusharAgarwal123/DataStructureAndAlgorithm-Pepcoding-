package com.ds.level2.Graph;

import java.util.PriorityQueue;

//778. Swim in Rising Water
public class SwimInRisingWater {

	static class Pair implements Comparable<Pair> {
		int i;
		int j;
		int cost;

		Pair(int i, int j, int t) {
			this.i = i;
			this.j = j;
			this.cost = t;
		}

		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}
	}

	int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int swimInWater(int[][] grid) {

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		PriorityQueue<Pair> q = new PriorityQueue<>();

		q.add(new Pair(0, 0, grid[0][0]));

		while (q.size() > 0) {

			Pair rem = q.remove();

			if (visited[rem.i][rem.j] == true) {
				continue;
			}

			visited[rem.i][rem.j] = true;

			if (rem.i == grid.length - 1 && rem.j == grid[0].length - 1) {
				return rem.cost;
			}

			for (int dr[] : dir) {
				int nx = rem.i + dr[0];
				int ny = rem.j + dr[1];

				addNeighbors(visited, q, grid, nx, ny, rem.cost);

			}

		}

		return -1;

	}

	public void addNeighbors(boolean visited[][], PriorityQueue<Pair> q, int grid[][], int x, int y, int cost) {

		if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length || visited[x][y] == true) {
			return;
		}

		q.add(new Pair(x, y, Math.max(cost, grid[x][y])));

	}

}
