package com.ds.level2.ArrayAndString;

import java.util.ArrayList;
import java.util.Collections;

//Chocolate Distribution Problem on gfg

/*
 * Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates
 *  in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to
 *   distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates
 given to a student is minimum.
 */

public class ChocolateDistributionProblem {

	public long findMinDiff(ArrayList<Integer> a, int n, int m) {
		// your code here

		Collections.sort(a);

		int s = 0;
		int e = m - 1;

		int min = Integer.MAX_VALUE;

		while (e < a.size()) {
			int diff = a.get(e) - a.get(s);
			min = Math.min(min, diff);
			e++;
			s++;
		}

		return min;

	}

}
