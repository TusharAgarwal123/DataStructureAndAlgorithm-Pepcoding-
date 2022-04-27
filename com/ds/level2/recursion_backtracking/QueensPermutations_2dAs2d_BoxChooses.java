package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the permutations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
 */
public class QueensPermutations_2dAs2d_BoxChooses {

	// here in level we are taking the board and in choice we have queens.
	public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
		// write your code here

		if (row == tq) {
			if (qpsf == tq) {
				System.out.println(asf);
				System.out.println();
			}

			return;
		}

		if (col != tq - 1) { // if not a last column.

			for (int i = 0; i < queens.length; i++) {

				if (queens[i] == false) {

					queens[i] = true;
					queensPermutations(qpsf + 1, tq, row, col + 1, asf + "q" + (i + 1) + "	", queens);
					queens[i] = false;

				}

			}

			queensPermutations(qpsf, tq, row, col + 1, asf + "-	", queens);

		} else {

			for (int i = 0; i < queens.length; i++) {

				if (queens[i] == false) {
					queens[i] = true;
					queensPermutations(qpsf + 1, tq, row + 1, 0, asf + "q" + (i + 1) + "", queens);
					queens[i] = false;
				}

			}

			queensPermutations(qpsf, tq, row + 1, 0, asf + "-", queens);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[] queens = new boolean[n];

		queensPermutations(0, n, 0, 0, "", queens);
	}

}
