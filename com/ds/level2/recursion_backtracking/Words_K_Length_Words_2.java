package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
     word.
 */
public class Words_K_Length_Words_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		HashSet<Character> unique = new HashSet<>();
		String ustr = "";
		for (char ch : str.toCharArray()) {
			if (unique.contains(ch) == false) {
				unique.add(ch);
				ustr += ch;
			}
		}

		solve(1, k, ustr, new HashSet<>(), "");

	}

	// you can relate this question with permutation-1
	// on level we are putting the spots and in options we have characters
	// here we are generating the permutations.
	public static void solve(int cs, int ts, String ustr, HashSet<Character> set, String asf) {

		if (cs > ts) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < ustr.length(); i++) {

			char ch = ustr.charAt(i);

			if (!set.contains(ch)) {
				set.add(ch);
				solve(cs + 1, ts, ustr, set, asf + ch);
				set.remove(ch);
			}

		}

	}

}
