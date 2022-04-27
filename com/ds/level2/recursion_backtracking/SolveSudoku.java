package com.ds.level2.recursion_backtracking;

import java.util.Scanner;

/*
 * 1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
 */
public class SolveSudoku {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int[][] arr = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		solveSudoku(arr, 0, 0);
	}

	public static void display(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void solveSudoku(int[][] board, int i, int j) {
		// write yopur code here
		if (i == board.length) {
			display(board);
			return;
		}

		int ni = 0;
		int nj = 0;

		if (j == board[0].length - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}

		if (board[i][j] != 0) {
			solveSudoku(board, ni, nj);
		} else {

			for (int num = 1; num <= 9; num++) {

				if (isSafe(num, board, i, j)) {
					board[i][j] = num;
					solveSudoku(board, ni, nj);
					board[i][j] = 0;
				}

			}

		}

	}

	public static boolean isSafe(int num, int[][] board, int i, int j) {

		// horizontally
		for (int col = 0; col < board.length; col++) {
			if (board[i][col] == num) {
				return false;
			}
		}

		// vertically
		for (int row = 0; row < board.length; row++) {
			if (board[row][j] == num) {
				return false;
			}
		}

		// sub-matrix of 3*3 size.

		int x = i / 3 * 3;
		int y = j / 3 * 3;

		for (int ii = 0; ii < 3; ii++) {
			for (int jj = 0; jj < 3; jj++) {
				if (board[x + ii][y + jj] == num) {
					return false;
				}
			}
		}

		return true;

	}

}
