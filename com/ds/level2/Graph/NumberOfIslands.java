package com.ds.level2.Graph;

//leetcode 200. Number of Islands.
public class NumberOfIslands {

	int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int numIslands(char[][] grid) {

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		int c = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && visited[i][j] == false) {
					c++;
					traverse(grid, visited, i, j);
				}
			}
		}

		return c;

	}

	public void traverse(char[][] grid, boolean visited[][], int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0') {
			return;
		}

		visited[i][j] = true;

		for (int dr[] : dir) {

			int ni = i + dr[0];
			int nj = j + dr[1];

			traverse(grid, visited, ni, nj);

		}

		// traverse(grid,visited,i,j+1);
		// traverse(grid,visited,i,j-1);
		// traverse(grid,visited,i+1,j);
		// traverse(grid,visited,i-1,j);

	}

}
