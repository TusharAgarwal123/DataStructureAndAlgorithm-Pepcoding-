package com.ds.level1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. 
3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
4. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
 */

public class GetMazePathWithJumpsArrayList {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(getMazePaths(1, 1, n, m));

	}

	// sr - source row
	// sc - source column
	// dr - destination row
	// dc - destination column
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

		if (sr == dr && sc == dc) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		ArrayList<String> path = new ArrayList<>();

		// horizontally
		for (int hr = 1; hr <= dc - sc; hr++) {

			ArrayList<String> hPath = getMazePaths(sr, sc + hr, dr, dc);

			for (String val : hPath) {
				path.add("h" + hr + val);
			}

		}

		// vertically
		for (int vr = 1; vr <= dr - sr; vr++) {

			ArrayList<String> vPath = getMazePaths(sr + vr, sc, dr, dc);

			for (String val : vPath) {
				path.add("v" + vr + val);
			}

		}

		// diagonal
		for (int diag = 1; diag <= dc - sc && diag <= dr - sr; diag++) {

			ArrayList<String> dPath = getMazePaths(sr + diag, sc + diag, dr, dc);

			for (String val : dPath) {
				path.add("d" + diag + val);
			}

		}

		return path;

	}

}
