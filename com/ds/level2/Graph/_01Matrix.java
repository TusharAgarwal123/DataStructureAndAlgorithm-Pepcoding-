package com.ds.level2.Graph;

import java.util.LinkedList;
import java.util.Queue;

//542. 01 Matrix

/*
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
 */
public class _01Matrix {

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

	public int[][] updateMatrix(int[][] mat) {

		boolean visited[][] = new boolean[mat.length][mat[0].length];

		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] == 0) {
					q.add(new Pair(i, j, 0));
				}
			}
		}

		while (q.size() > 0) {

			Pair rem = q.remove();
			if (visited[rem.x][rem.y] == true) {
				continue;
			}

			visited[rem.x][rem.y] = true;

			mat[rem.x][rem.y] = rem.dis;

			for (int dr[] : dir) {

				int nx = rem.x + dr[0];
				int ny = rem.y + dr[1];
				addNeighBors(visited, mat, nx, ny, rem.dis + 1, q);

			}

		}

		return mat;

	}

	public void addNeighBors(boolean visited[][], int[][] mat, int x, int y, int dis, Queue<Pair> q) {

		if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length || visited[x][y] == true || mat[x][y] == 0) {
			return;
		}

		q.add(new Pair(x, y, dis));

	}

}
