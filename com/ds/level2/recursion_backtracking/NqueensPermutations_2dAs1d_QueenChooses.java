package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens (distinct) can be 
     placed on the n * n chess-board. 
3. No queen shall be able to kill another.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
 */
public class NqueensPermutations_2dAs1d_QueenChooses {

	// Time Complexity = (n*n)^n.
	public static void nqueens(int qpsf, int tq, int[][] chess) {
		// write your code here
		if (qpsf == tq) {
			for (int row = 0; row < chess.length; row++) {
				for (int col = 0; col < chess.length; col++) {
					System.out.print(chess[row][col] != 0 ? "q" + chess[row][col] + "	" : "-	");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < chess.length * chess.length; i++) {
			int row = i / chess.length;
			int col = i % chess.length;

			if (chess[row][col] == 0 && IsQueenSafe(chess, row, col)) {
				chess[row][col] = qpsf + 1;
				nqueens(qpsf + 1, tq, chess);
				chess[row][col] = 0;
			}
		}
	}

	// we are finding the permutation so we need to check in all 8 direction.
	public static boolean IsQueenSafe(int[][] chess, int row, int col) {
		// write your code here

		// left horizontally
		for (int j = 0; j < col; j++) {
			if (chess[row][j] != 0) {
				return false;
			}
		}

		// right horizontally
		for (int j = col; j < chess.length; j++) {
			if (chess[row][j] != 0) {
				return false;
			}
		}

		// upper vertically
		for (int i = 0; i < row; i++) {
			if (chess[i][col] != 0) {
				return false;
			}
		}

		// lower vertically
		for (int i = row; i < chess.length; i++) {
			if (chess[i][col] != 0) {
				return false;
			}
		}

		// upper left diagonal
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (chess[i][j] != 0) {
				return false;
			}
		}

		// lower right diagonal
		for (int i = row + 1, j = col + 1; i < chess.length && j < chess.length; i++, j++) {
			if (chess[i][j] != 0) {
				return false;
			}
		}

		// upper right diagonal
		for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
			if (chess[i][j] != 0) {
				return false;
			}
		}

		// lower left diagonal
		for (int i = row + 1, j = col - 1; i < chess.length && j >= 0; i++, j--) {
			if (chess[i][j] != 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] chess = new int[n][n];

		nqueens(0, n, chess);
	}

}
