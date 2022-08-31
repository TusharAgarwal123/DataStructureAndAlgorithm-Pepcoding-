package com.ds.level1.DP;

import java.util.Scanner;

/*
 * 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
 */

//leetcode 2320.
public class ArrangeBuildings {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long ans = arrangeBuildingsUsingDP(n);
		System.out.println(ans);

	}

	public static long arrangeBuildingsUsingDP(int n) {

		long building[] = new long[n + 1];
		long space[] = new long[n + 1];

		building[1] = 1;
		space[1] = 1;

		for (int i = 2; i <= n; i++) {

			building[i] = space[i - 1];
			space[i] = space[i - 1] + building[i - 1];
		}

		long total = building[n] + space[n];

		total = total * total;
		return total;

	}

	public static long arrangeBuildingsUsingGreedy(int n) {

		long building = 1;
		long space = 1;

		for (int i = 2; i <= n; i++) {
			long nbuilding = space;
			long nspace = space + building;

			building = nbuilding;
			space = nspace;
		}

		long total = building + space;

		total = total * total;
		return total;

	}

}
