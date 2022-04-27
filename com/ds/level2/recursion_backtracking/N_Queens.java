package com.ds.level2.recursion_backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement,
 where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

/*
 * Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:

Input: n = 1
Output: [["Q"]]
 */
public class N_Queens {

	// leetcode 51.
	public List<List<String>> solveNQueens(int n) {

		List<List<String>> ans = new ArrayList<>();

		countPuzzle(new boolean[n][n], 0, ans);

		return ans;

	}

	public void countPuzzle(boolean[][] chess, int row, List<List<String>> list) {

		if (row == chess.length) {

			List<String> ans = new ArrayList<>();
			for (int i = 0; i < chess.length; i++) {
				String str = "";
				for (int j = 0; j < chess.length; j++) {
					if (chess[i][j]) {
						str = str + "Q";
					} else {
						str = str + ".";
					}
				}

				ans.add(str);
			}

			list.add(ans);

			return;

		}

		for (int col = 0; col < chess.length; col++) {

			if (chess[row][col] == false && isSafe(chess, row, col)) {
				chess[row][col] = true;
				countPuzzle(chess, row + 1, list);
				chess[row][col] = false;
			}

		}

	}

	public boolean isSafe(boolean chess[][], int row, int col) {

		for (int i = 0; i < col; i++) {
			if (chess[row][i]) {
				return false;
			}
		}

		for (int i = 0; i < row; i++) {
			if (chess[i][col]) {
				return false;
			}
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j]) {
				return false;
			}
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j]) {
				return false;
			}
		}

		return true;

	}

}
