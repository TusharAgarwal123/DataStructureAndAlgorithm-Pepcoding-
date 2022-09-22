package com.ds.level2.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Generate Binary Numbers on gfg.

/*
 * Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.
 */

public class GenerateBinaryNumbers {

	static ArrayList<String> generate(int N) {
		// Your code here

		ArrayList<String> list = new ArrayList<>();

		if (N == 0) {
			return list;
		}

		Queue<String> q = new LinkedList<>();
		q.add("1");

		int i = 1;

		while (i <= N) {

			String rem = q.remove();
			list.add(rem);

			q.add(rem + "0");
			q.add(rem + "1");

			i++;

		}

		return list;

	}

}
