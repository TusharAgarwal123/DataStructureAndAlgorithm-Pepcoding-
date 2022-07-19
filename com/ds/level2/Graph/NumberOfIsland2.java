package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an m*n matrix mat, Originally, the 2D matrix is all 0 which means there is only sea in the matrix.
 *  The list pair has k operator and each operator has two integer A[i].x, A[i].y means that you can change
 *   the grid mat[A[i].x][A[i].y] from sea to island. Return how many island are there in the matrix after
 *    each operator.You need to return an array of size K.

 */

public class NumberOfIsland2 {

	static int parent[];
	static int rank[];
	static int count;

	public static List<Integer> numIslands2(int row, int col, int[][] positions) {

		int grid[][] = new int[row][col];

		parent = new int[row * col];
		rank = new int[row * col];

		for (int i = 0; i < row * col; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		List<Integer> list = new ArrayList<>();
		count = 0;

		for (int ar[] : positions) {
			int x = ar[0];
			int y = ar[1];

			grid[x][y] = 1;

			count++;

			handleNewCell(x, y, x - 1, y, row, col, grid);
			handleNewCell(x, y, x + 1, y, row, col, grid);
			handleNewCell(x, y, x, y - 1, row, col, grid);
			handleNewCell(x, y, x, y + 1, row, col, grid);

			list.add(count);
		}

		return list;
	}

	public static void handleNewCell(int x, int y, int xx, int yy, int row, int col, int grid[][]) {

		if (xx < 0 || yy < 0 || xx >= row || yy >= col || grid[xx][yy] == 0) {
			return;
		}

		int xyCell = x * col + y;
		int xxyyCell = xx * col + yy;

		int xyLead = find(xyCell);
		int xxyyLead = find(xxyyCell);

		if (xyLead != xxyyLead) {
			count--;
			union(xyLead, xxyyLead);
		}

	}

	public static int find(int x) {

		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}

	}

	public static void union(int v1, int v2) {

		if (rank[v1] < rank[v2]) {
			parent[v1] = v2;
		} else if (rank[v2] < rank[v1]) {
			parent[v2] = v1;
		} else {
			parent[v1] = v2;
			rank[v2]++;
		}

	}

}
