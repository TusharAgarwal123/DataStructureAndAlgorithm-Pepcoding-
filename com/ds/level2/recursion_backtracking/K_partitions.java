package com.ds.level2.recursion_backtracking;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given two integers n and k, where n represents number of elements and k represents 
     number of subsets.
2. You have to partition n elements in k subsets and print all such configurations.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept
 */
public class K_partitions {

	static int c = 1;

	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		// write your code here

		if (i > n) {
			if (rssf == k) {
				System.out.print(c + ". ");
				c++;

				for (ArrayList<Integer> set : ans) {
					System.out.print(set + " ");
				}

				System.out.println();
			}

			return;
		}

		for (int j = 0; j < ans.size(); j++) {

			if (ans.get(j).size() > 0) {
				ans.get(j).add(i);
				solution(i + 1, n, k, rssf, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
			} else {// for blank set
				ans.get(j).add(i);
				solution(i + 1, n, k, rssf + 1, ans);
				ans.get(j).remove(ans.get(j).size() - 1);
				break; // we will put only in one empty set.
			}

		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}
