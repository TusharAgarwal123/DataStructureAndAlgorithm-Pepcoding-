package com.ds.level2.Graph;

import java.util.LinkedList;
import java.util.Queue;

//leetcode 1162. As Far from Land as Possible

/*
 * Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
 *  find a water cell such that its distance to the nearest land cell is maximized, and return the distance. 
 *  If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and 
(x1, y1) is |x0 - x1| + |y0 - y1|.
 */
public class AsFarFromLandAsPossible {

	static class Pair {
		int x;
		int y;
		int dis;

		Pair(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public int maxDistance(int[][] mat) {

		int max = -1;

		boolean visited[][] = new boolean[mat.length][mat[0].length];

		Queue<Pair> q = new LinkedList<>();

		boolean noZero = true;

		// first adding all the land cells.
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 1) {
					q.add(new Pair(i, j, 0));
				} else {
					noZero = false;
				}
			}
		}

		// if water is not present.
		if (noZero) {
			return -1;
		}

		while (q.size() > 0) {

			Pair rem = q.remove();
			if (visited[rem.x][rem.y] == true) {
				continue;
			}

			visited[rem.x][rem.y] = true;

			max = Math.max(max, rem.dis);

			for (int dr[] : dir) {

				int nx = rem.x + dr[0];
				int ny = rem.y + dr[1];

				addNeighBors(visited, mat, nx, ny, rem.dis + 1, q);

			}

		}

		return max;

	}

	public void addNeighBors(boolean visited[][], int[][] mat, int x, int y, int dis, Queue<Pair> q) {

		if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || visited[x][y] == true) {
			return;
		}

		q.add(new Pair(x, y, dis));

	}

}
