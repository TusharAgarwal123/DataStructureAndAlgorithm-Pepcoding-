package com.ds.level2.recursion_backtracking;

import java.util.HashSet;
import java.util.Scanner;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
     word.
 */
public class Words_K_Selection_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();

		HashSet<Character> set = new HashSet<>();
		String ustr = "";

		for (char ch : str.toCharArray()) {
			if (!set.contains(ch)) {
				set.add(ch);
				ustr += ch;
			}
		}

		solution(1, k, ustr, -1, "");

	}

	// on level we are putting the characters and in option we have boxes.
	public static void solution(int cs, int ts, String ustr, int lc, String asf) {

		if (cs > ts) {
			System.out.println(asf);
			return;
		}

		for (int i = lc + 1; i < ustr.length(); i++) {
			solution(cs + 1, ts, ustr, i, asf + ustr.charAt(i));
		}

	}

}
