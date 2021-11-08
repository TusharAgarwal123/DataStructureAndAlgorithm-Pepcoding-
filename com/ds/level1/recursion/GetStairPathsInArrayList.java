package com.ds.level1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.
 */
public class GetStairPathsInArrayList {

	public static void main(String[] args) throws Exception {

		System.out.println("Enter the no of stairs:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(getStairPaths(n));

	}

	public static ArrayList<String> getStairPaths(int n) {

		if (n == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		if (n < 0) {

			ArrayList<String> list = new ArrayList<>();

			return list;

		}

		ArrayList<String> pathFromNm1 = getStairPaths(n - 1);
		ArrayList<String> pathFromNm2 = getStairPaths(n - 2);
		ArrayList<String> pathFromNm3 = getStairPaths(n - 3);

		ArrayList<String> res = new ArrayList<>();

		for (String val : pathFromNm1) {
			res.add("1" + val);
		}

		for (String val : pathFromNm2) {
			res.add("2" + val);
		}
		for (String val : pathFromNm3) {
			res.add("3" + val);
		}

		return res;

	}

}
