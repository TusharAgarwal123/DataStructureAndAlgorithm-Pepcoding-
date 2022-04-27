package com.ds.level2.recursion_backtracking;

import java.util.Scanner;

/*
 * 1. You are given an integer n, which represents n friends numbered from 1 to n.
2. Each one can remain single or can pair up with some other friend.
3. You have to print all the configurations in which friends can remain single or can be paired up.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
 */
public class FriendsPairing {

	static int counter = 1;

	public static void solution(int i, int n, boolean[] used, String asf) {
		// write your code here

		if (i > n) {
			System.out.println(counter + "." + asf);
			counter++;
			return;
		}

		if (used[i]) {
			solution(i + 1, n, used, asf);
		} else {
			used[i] = true;
			solution(i + 1, n, used, asf + "(" + i + ") ");
			used[i] = false;

			for (int j = i + 1; j <= n; j++) {
				if (used[j] == false) {
					used[i] = true;
					used[j] = true;
					solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
					used[j] = false;
					used[i] = false;
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] used = new boolean[n + 1];
		solution(1, n, used, "");
	}

}
