package com.ds.level1.recursion;

import java.util.Scanner;

public class PrintMazePathsWithJumps {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		printMazePaths(1, 1, r, c, "");

	}

	// sr - source row
	// sc - source column
	// dr - destination row
	// dc - destination column
	public static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {

		if (sr == dr && sc == dc) {
			System.out.println(ans);
			return;
		}

		// horizontally
		for (int i = 1; i <= dc - sc; i++) {
			printMazePaths(sr, sc + i, dr, dc, ans + "h" + i);
		}

		// vertically
		for (int i = 1; i <= dr - sr; i++) {
			printMazePaths(sr + i, sc, dr, dc, ans + "v" + i);
		}

		// diagonally
		for (int i = 1; i <= dc - sc && i <= dr - sr; i++) {
			printMazePaths(sr + i, sc + i, dr, dc, ans + "d" + i);
		}

	}

}
