package com.ds.level2.Graph;

//leetcode 1020. Number of Enclaves
public class NumberOfEnclaves {

	int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	int len = 0;
	boolean flag = true;

	public int numEnclaves(int[][] grid) {

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		int count = 0;

		for (int i = 1; i < grid.length - 1; i++) {
			for (int j = 1; j < grid[0].length - 1; j++) {
				if (grid[i][j] == 1 && visited[i][j] == false) {
					len = 0;
					flag = true;
					traverse(grid, visited, i, j);
					if (flag) {
						count += len;
					}

				}
			}
		}

		return count;

	}

	public void traverse(int[][] grid, boolean visited[][], int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			flag = false;
			return;

		} else if (grid[i][j] == 0) {
			return;
		} else if (visited[i][j] == true) {
			return;
		}

		len++;
		visited[i][j] = true;
		for (int dr[] : dir) {

			int ni = i + dr[0];
			int nj = j + dr[1];

			traverse(grid, visited, ni, nj);

		}

	}

}
