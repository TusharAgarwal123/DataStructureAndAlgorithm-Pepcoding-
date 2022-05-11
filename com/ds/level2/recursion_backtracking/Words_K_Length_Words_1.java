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
public class Words_K_Length_Words_1 {

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

		solve(ustr, 0, 0, k, new Character[k]);

	}

	// you can relate this question with permutation-2
	// on level we are putting the characters and in options we have boxes, each
	// character can come in any box
	// or cannot come in any box. here we are generating the permutations.
	public static void solve(String ustr, int idx, int ssf, int k, Character spot[]) {

		if (idx == ustr.length()) {

			if (ssf == k) {
				for (char ch : spot) {
					System.out.print(ch);
				}
				System.out.println();
			}
			return;
		}

		for (int i = 0; i < spot.length; i++) {

			if (spot[i] == null) {
				spot[i] = ustr.charAt(idx);
				solve(ustr, idx + 1, ssf + 1, k, spot);
				spot[i] = null;
			}

		}

		solve(ustr, idx + 1, ssf, k, spot);

	}

}
