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
public class QueensCombinations_2dAs1d_QueenChooses {

	// Time Complexity = (n*n)^n.
	// here in level we are taking the queens and in choice we have chess board.
	// here we are treating 2d as 1d because of that it become easy to run a loop of
	// boxes.
	// by using this approach we can solve other similar questions.
	public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
		// write your code here
		if (qpsf == tq) {
			for (int i = 0; i < chess.length; i++) {
				for (int j = 0; j < chess.length; j++) {
					if (chess[i][j]) {
						System.out.print("q\t");
					} else {
						System.out.print("-\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}

		for (int i = lcno + 1; i < chess.length * chess.length; i++) {
			int r = i / chess.length;
			int c = i % chess.length;

			// if(chess[r][c]==false){
			chess[r][c] = true;
			queensCombinations(qpsf + 1, tq, chess, i);
			chess[r][c] = false;
			// }
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] chess = new boolean[n][n];

		queensCombinations(0, n, chess, -1);
	}

}
