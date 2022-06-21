package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//1034. Coloring A Border
public class ColoringABorder {

	static class Pair {
		int x;
		int y;
		boolean isBor; // isBorder

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int[][] colorBorder(int[][] grid, int row, int col, int color) {

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		Queue<Pair> q = new LinkedList<>();

		Pair p = new Pair(row, col);

		p.isBor = isBorder(grid, row, col);

		q.add(p);

		int orgCol = grid[row][col];

		ArrayList<Pair> res = new ArrayList<>();

		while (q.size() > 0) {

			Pair rem = q.remove();

			if (visited[rem.x][rem.y] == true) {
				continue;
			}

			visited[rem.x][rem.y] = true;

			if (rem.isBor) {
				res.add(rem);
			}

			for (int dr[] : dir) {

				int nx = dr[0] + rem.x;
				int ny = dr[1] + rem.y;

				addNeighbors(grid, nx, ny, orgCol, visited, q);

			}

		}

		for (Pair pp : res) {
			grid[pp.x][pp.y] = color;
		}

		return grid;

	}

	public void addNeighbors(int[][] grid, int row, int col, int orgCol, boolean visited[][], Queue<Pair> q) {

		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] == true
				|| grid[row][col] != orgCol) {
			return;
		}

		Pair p = new Pair(row, col);
		p.isBor = isBorder(grid, row, col);

		q.add(p);

	}

	// it will check weather the given i and j are at border or not.
	public boolean isBorder(int grid[][], int i, int j) {

		if (i == 0) {
			return true;
		} else if (i == grid.length - 1) {
			return true;
		} else if (j == 0) {
			return true;
		} else if (j == grid[0].length - 1) {
			return true;
		} else {
			int color = grid[i][j];
			if (grid[i - 1][j] != color) {
				return true;
			} else if (grid[i + 1][j] != color) {
				return true;
			} else if (grid[i][j + 1] != color) {
				return true;
			} else if (grid[i][j - 1] != color) {
				return true;
			} else {
				return false;
			}
		}

	}

}
