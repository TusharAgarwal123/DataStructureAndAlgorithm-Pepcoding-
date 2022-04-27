package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. You are give a number of boxes (nboxes) and number of identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are identical and all of them are named 'i'
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without 
                   changing signature. The judge can't force you but intends you to teach a concept.
 */
public class Combination_2 {

	// Time Complexity => (no of boxes)^(no of items)
	// here in level we are taking the items and in choice we have boxes.
	public static void combinations(int[] boxes, int ci, int ti, int lb) {
		// write your code here

		if (ci > ti) {
			for (int x : boxes) {
				if (x != 0) {
					System.out.print("i");
				} else {
					System.out.print("-");
				}
			}

			System.out.println();
			return;
		}

		for (int i = lb + 1; i < boxes.length; i++) {
			boxes[i] = ci;
			combinations(boxes, ci + 1, ti, i);
			boxes[i] = 0;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nboxes = Integer.parseInt(br.readLine());
		int ritems = Integer.parseInt(br.readLine());
		combinations(new int[nboxes], 1, ritems, -1);
	}

}
