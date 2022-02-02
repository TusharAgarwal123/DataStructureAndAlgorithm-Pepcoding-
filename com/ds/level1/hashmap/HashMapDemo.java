package com.ds.level1.hashmap;

import java.util.HashMap;

public class HashMapDemo {

	/*
	 * 1. You are given a string str. 2. You are required to find the character with
	 * maximum frequency.
	 */
	public static void highestFrequencyChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		char mc = str.charAt(0);
		for (char key : map.keySet()) {
			if (map.get(key) > map.get(mc)) {
				mc = key;
			}
		}

		System.out.println(mc);

	}

	/*
	 * 1. You are given a number n1, representing the size of array a1. 2. You are
	 * given n1 numbers, representing elements of array a1. 3. You are given a
	 * number n2, representing the size of array a2. 4. You are given n2 numbers,
	 * representing elements of array a2. 5. You are required to print all elements
	 * of a2 which are also present in a1 (in order of their occurence in a2). Make
	 * sure to not print duplicates (a2 may have same value present many times).
	 */
	public static void printCommonElements(int ar1[], int ar2[]) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int x : ar1) {
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}

		for (int x : ar2) {
			if (map.containsKey(x)) {
				System.out.println(x);
				map.remove(x);
			}
		}

	}

	/*
	 * you have given two array of integers. you have to find the intersection of
	 * both array.
	 */
	public static void printCommonElements2(int ar1[], int ar2[]) {

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int x : ar1) {
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}

		for (int x : ar2) {
			if (map.containsKey(x) && map.get(x) > 0) {
				System.out.println(x);
				map.put(x, map.get(x) - 1);
			}
		}

	}

	/*
	 * 1. You are given a number n, representing the size of array a. 2. You are
	 * given n numbers, representing elements of array a. 3. You are required to
	 * print the longest sequence of consecutive elements in the array (ignoring
	 * duplicates).
	 * 
	 * Note -> In case there are two sequences of equal length (and they are also
	 * the longest), then print the one for which the starting point of which occurs
	 * first in the array.
	 */
	public static void printLongestConsecutiveSequence(int ar[]) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		// true will denote that element is starting point of sequence.
		// false will denote that element is not starting point of sequence.

		// here i am assuming that all element are the starting point of sequence.
		for (int x : ar) {
			map.put(x, true);
		}

		// here, finally identifying the element which are really starting point of
		// sequence.
		for (int x : ar) {
			if (map.containsKey(x - 1)) {
				map.put(x, false);
			}
		}

		int ml = 0; // maximum length.
		int msp = 0; // maximum starting point.
		for (int x : ar) {

			if (map.get(x)) { // taking only those which are starting point of sequence.

				int tl = 1; // temporary length.
				int tsp = x; // temporary starting point.

				while (map.containsKey(tsp + tl)) { // calculating the length of sequence.
					tl++;
				}

				if (tl > ml) {
					ml = tl;
					msp = tsp;
				}

			}

		}

		for (int i = 0; i < ml; i++) {
			System.out.println(msp + i);
		}

	}

	public static void main(String[] args) {

		String str = "zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc";
		highestFrequencyChar(str);

	}

}
