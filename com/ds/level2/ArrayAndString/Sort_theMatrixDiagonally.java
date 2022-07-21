package com.ds.level2.ArrayAndString;

import java.util.HashMap;
import java.util.PriorityQueue;

//1329. Sort the Matrix Diagonally

/*
 * A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost
 *  column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix 
 *  diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and
 *   mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting
 matrix.
 */

public class Sort_theMatrixDiagonally {

	// complexity => O(mnlog(min(m,n)))
	public int[][] diagonalSort(int[][] mat) {

		HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		int m = mat.length;
		int n = mat[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int gap = i - j;

				if (map.containsKey(gap) == false) {
					map.put(gap, new PriorityQueue<>());
				}

				map.get(gap).add(mat[i][j]);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int gap = i - j;
				mat[i][j] = map.get(gap).remove();
			}
		}

		return mat;

	}

}
