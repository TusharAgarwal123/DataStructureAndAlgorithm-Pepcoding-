package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. You are given a number n, representing the size of a n * n chess board.
2. You are required to calculate and print the combinations in which n queens can be placed on the 
     n * n chess-board. 

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
               force you but the intention is to teach a concept. Play in spirit of the question.
 */
public class QueensCombinations_2dAs2d_BoxChooses {

	// here in level we are taking the board and in choice we have queens.
	public static void queensCombinations(int qpsf, int tq, int row, int col, String asf) {
		// write your code here

		// write your code here
		if (row == tq) {
			if (qpsf == tq) {
				System.out.println(asf);
			}
			return;
		}

		if (col != tq - 1) { // if not a last column.
			queensCombinations(qpsf + 1, tq, row, col + 1, asf + "q");
			queensCombinations(qpsf, tq, row, col + 1, asf + "-");
		} else {
			queensCombinations(qpsf + 1, tq, row + 1, 0, asf + "q\n");
			queensCombinations(qpsf, tq, row + 1, 0, asf + "-\n");
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		queensCombinations(0, n, 0, 0, "");
	}

}
