package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
2. You are required to place the items in those boxes and print all such configurations possible.

Items are numbered from 1 to ritems.
Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
                   empty.
Note 2 -> Check out the question video and write the recursive code as it is intended without 
                   changing signature. The judge can't force you but intends you to teach a concept.
 */
public class Permutation_2 {

	// Time Complexity => (no of items)^(no of boxes)
	// here in level we are taking the boxes and in choice we have items.
	public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf) {
		// write your code here

		if (cb > tb) {
			if (ssf == ts) {
				System.out.print(asf);
				System.out.println();
			}

			return;
		}

		for (int i = 0; i < items.length; i++) {
			if (items[i] == 0) {
				items[i] = cb;
				permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i + 1));
				items[i] = 0;
			}
		}

		permutations(cb + 1, tb, items, ssf, ts, asf + 0);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nboxes = Integer.parseInt(br.readLine());
		int ritems = Integer.parseInt(br.readLine());
		permutations(1, nboxes, new int[ritems], 0, ritems, "");
	}

}
