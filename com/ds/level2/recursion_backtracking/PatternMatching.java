package com.ds.level2.recursion_backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/*
 * 1. You are given a string and a pattern. 
2. You've to check if the string is of the same structure as pattern without using any regular 
     expressions.
 */
public class PatternMatching {

	// on level we will put all the character of pattern and in options we will have
	// all substring of string.
	public static void solution(String str, String pattern, HashMap<Character, String> map, String op) {
		// write your code here

		if (pattern.length() == 0) {
			if (str.length() == 0) {

				HashSet<Character> set = new HashSet<>();
				for (int i = 0; i < op.length(); i++) {
					char ch = op.charAt(i);
					if (!set.contains(ch)) {
						set.add(ch);
						System.out.print(ch + " -> " + map.get(ch) + ", ");
					}
				}
				System.out.println(".");

			}

			return;
		}

		char ch = pattern.charAt(0);
		String rop = pattern.substring(1);
		if (map.containsKey(ch)) {

			String previousMapping = map.get(ch);
			if (str.length() >= previousMapping.length()) {

				String left = str.substring(0, previousMapping.length());
				String right = str.substring(previousMapping.length());

				if (left.equals(previousMapping)) {
					solution(right, rop, map, op);
				}

			}

		} else {
			for (int i = 0; i < str.length(); i++) {
				String left = str.substring(0, i + 1);
				String right = str.substring(i + 1);
				map.put(ch, left);
				solution(right, rop, map, op);
				map.remove(ch);
			}
		}

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character, String> map = new HashMap<>();
		solution(str, pattern, map, pattern);
	}

}
