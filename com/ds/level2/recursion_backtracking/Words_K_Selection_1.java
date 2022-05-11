package com.ds.level2.recursion_backtracking;

import java.util.HashSet;
import java.util.Scanner;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k distinct characters out of the 
     word.

 */
public class Words_K_Selection_1 {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		int k = scn.nextInt();

		HashSet<Character> unique = new HashSet<>();
		String ustr = "";
		for (char ch : str.toCharArray()) {
			if (unique.contains(ch) == false) {
				unique.add(ch);
				ustr += ch;
			}
		}

		combination(0, ustr, 0, k, "");
	}

	// each character will have two choice to come or not come.
	public static void combination(int i, String ustr, int ssf, int ts, String asf) {

		if (i == ustr.length()) {
			if (ssf == ts) {
				System.out.println(asf);

			}

			return;
		}

		char ch = ustr.charAt(i);
		combination(i + 1, ustr, ssf + 1, ts, asf + ch);
		combination(i + 1, ustr, ssf, ts, asf);

	}

}
