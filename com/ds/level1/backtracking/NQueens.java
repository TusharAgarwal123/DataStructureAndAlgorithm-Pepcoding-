package com.ds.level1.backtracking;

import java.util.Scanner;

/*
 * . You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens. Use sample input and output to get more idea.
 */

public class NQueens {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int chess[][] = new int[n][n];
		printNQueens(chess, "", 0);

	}

	public static void printNQueens(int[][] chess, String qsf, int row) {

		if (row == chess.length) {
			System.out.println(qsf + ".");
			return;
		}

		for (int col = 0; col < chess[0].length; col++) {
			if (isSafe(chess, row, col)) {
				chess[row][col] = 1;
				printNQueens(chess, qsf + row + "-" + col + ", ", row + 1);
				chess[row][col] = 0;
			}
		}

	}

	public static boolean isSafe(int ar[][], int row, int col) {

		// vertically
		for (int r = row - 1; r >= 0; r--) {
			if (ar[r][col] == 1) {
				return false;
			}
		}

		// upper left diagonal

		for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
			if (ar[r][c] == 1) {
				return false;
			}
		}

		// upper right diagonal

		for (int r = row - 1, c = col + 1; r >= 0 && c < ar[0].length; r--, c++) {
			if (ar[r][c] == 1) {
				return false;
			}
		}
		return true;

	}

}
