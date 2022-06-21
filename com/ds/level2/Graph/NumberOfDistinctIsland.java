package com.ds.level2.Graph;

import java.util.HashSet;

/*
 * Given an m*n binary matrix mat, return the number of distinct island.

An island is considered to be the same as another if and only if one island can be translated
 (and not rotated or reflected) to equal the other.
 */
public class NumberOfDistinctIsland {

	static StringBuilder sb = new StringBuilder();

	public static int numDistinctIslands(int[][] grid) {
		// write your code here

		boolean visited[][] = new boolean[grid.length][grid[0].length];

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1 && visited[i][j] == false) {
					sb = new StringBuilder();
					traverse(grid, visited, i, j);
					set.add(sb.toString());
				}
			}
		}

		return set.size();

	}

	public static void traverse(int[][] grid, boolean visited[][], int i, int j) {

		visited[i][j] = true;

		if (j + 1 < grid[0].length && grid[i][j + 1] == 1 && visited[i][j + 1] == false) {
			sb.append("r");
			traverse(grid, visited, i, j + 1);
		}

		if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == false) {
			sb.append("l");
			traverse(grid, visited, i, j - 1);
		}

		if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == false) {
			sb.append("u");
			traverse(grid, visited, i - 1, j);
		}

		if (i + 1 < grid.length && grid[i + 1][j] == 1 && visited[i + 1][j] == false) {
			sb.append("d");
			traverse(grid, visited, i + 1, j);
		}

		// this is important to add direction while backtracking otherwise if two island
		// are mirror image
		// so they will give the same answer.
		sb.append("b");

	}

}
