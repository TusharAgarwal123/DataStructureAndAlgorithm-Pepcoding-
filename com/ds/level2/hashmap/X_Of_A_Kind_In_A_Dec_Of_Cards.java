package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * In a deck of cards, each card has an integer written on it.
 * 
 * Return true if and only if you can choose X >= 2 such that it is possible to
 * split the entire deck into 1 or more groups of cards, where:
 * 
 * Each group has exactly X cards. All the cards in each group have the same
 * integer.
 */
public class X_Of_A_Kind_In_A_Dec_Of_Cards {

	// leetcode 914
	public boolean hasGroupsSizeX(int[] deck) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int x : deck) {
			map.put(x, map.getOrDefault(x, 0) + 1);
		}

		int c = 0;
		int gcd = 1;
		for (int key : map.keySet()) {
			if (c == 0) {
				gcd = map.get(key);
			} else {
				int val = map.get(key);
				gcd = findGCD(val, gcd);
			}

			c++;
		}

		return gcd >= 2;

	}

	public int findGCD(int x1, int x2) {

		while (x1 % x2 != 0) {
			int rem = x1 % x2;
			x1 = x2;
			x2 = rem;
		}

		return x2;

	}

}
