package com.ds.level2.ArrayAndString;

import java.util.List;

//on interview bit.

public class AllocateBooks {

	public int solve(List<Integer> ar, int b) {

		if (ar.size() < b) {
			return -1;
		}

		int lo = Integer.MIN_VALUE;
		int hi = 0;

		for (int val : ar) {
			lo = Math.max(val, lo);
			hi += val;
		}

		while (lo < hi) {

			int allot = (lo + hi) / 2; // average no of pages that will allot to each student.

			int reqd = 1;
			int curr = 0;

			for (int val : ar) {
				if (curr + val <= allot) {
					curr = curr + val;
				} else {
					curr = val;
					reqd++;
				}
			}

			if (reqd > b) {
				lo = allot + 1;
			} else {
				hi = allot;
			}

		}

		return lo;

	}

}
