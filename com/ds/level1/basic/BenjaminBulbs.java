package com.ds.level1.basic;

public class BenjaminBulbs {

	/*
	 * you have n no of bulbs and all bulbs are initially off, there are n no of
	 * voltage fluctuation in each fluctuation voltage status will be toggle.if it
	 * is off->on and vice-verse. in first fluctuation all bulbs will be toggle. in
	 * 2nd fluctuation all bulbs which are multiple of 2 will be toggle. in 3rd
	 * fluctuation all bulbs which aremultiple of 3 will be toggle. and so on till
	 * n.
	 * 
	 * at the end you have to print all bulbs which are on.
	 * 
	 * Solution : answer of this question will be all perfect sqaure root till n.
	 * 
	 */

	public static void main(String[] args) {

		int n = 25;
		for (int i = 1; i * i <= n; i++) {
			System.out.println(i * i);
		}

	}
}
