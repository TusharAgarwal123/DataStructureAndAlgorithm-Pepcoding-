package com.ds.level2.recursion_backtracking;

import java.util.Scanner;

/*
 * 1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can 
     kill another.
Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and 
     print all safe configurations of n-queens

Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit 
               of question is.

Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch
 and bound technique and not test you.
 */
public class NQueensBranchAndBound {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		boolean[][] board = new boolean[n][n];
		// write your code here

		boolean[] col = new boolean[n];
		boolean[] normal = new boolean[2 * n - 1];
		boolean[] reverse = new boolean[2 * n - 1];

		placeQueens(board, 0, col, normal, reverse, "");

	}

	// this is optimized version of NQueens problem.
	public static void placeQueens(boolean[][] board, int row, boolean col[], boolean normal[], boolean reverse[],
			String asf) {

		if (row == board.length) {

			// for(int i=0;i<board.length;i++){
			// for(int j=0;j<board.length;j++){
			// if(board[i][j]){
			// System.out.print(i+"-"+j+", ");
			// }
			// }
			// }

			System.out.print(asf);
			System.out.print(".");
			System.out.println();
			return;

		}

		for (int i = 0; i < board.length; i++) {
			if (col[i] == false && normal[row + i] == false && reverse[row - i + board.length - 1] == false) {
				// board[row][i]=true;
				col[i] = true;
				normal[row + i] = true;
				reverse[row - i + board.length - 1] = true;
				placeQueens(board, row + 1, col, normal, reverse, asf + row + "-" + i + ", ");
				// board[row][i]=false;
				col[i] = false;
				normal[row + i] = false;
				reverse[row - i + board.length - 1] = false;
			}
		}

	}

}
