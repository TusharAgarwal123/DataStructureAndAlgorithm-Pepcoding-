package com.ds.level1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given a number n and a number m representing number of rows and columns in a maze.
2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).
3. Complete the body of getMazePath function - without changing signature - to get the list of all paths that can be used to move from top-left to bottom-right.
 */

public class GetMazePathInArrayList {

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

		if (sr > dr || sc > dc) {
			ArrayList<String> list = new ArrayList<>();
			return list;
		}

		ArrayList<String> hr = getMazePaths(sr, sc + 1, dr, dc);
		ArrayList<String> vr = getMazePaths(sr + 1, sc, dr, dc);

		ArrayList<String> res = new ArrayList<>();
		for (String val : hr) {
			res.add("h" + val);
		}
		for (String val : vr) {
			res.add("v" + val);
		}

		return res;

	}

}
