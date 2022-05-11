package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
2. You are required to generate and print all ways you can select k characters out of the word.

 */
public class Words_K_Selection_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		HashMap<Character, Integer> unique = new HashMap<>();
		String ustr = "";
		for (char ch : str.toCharArray()) {
			if (unique.containsKey(ch) == false) {
				unique.put(ch, 1);
				ustr += ch;
			} else {
				unique.put(ch, unique.get(ch) + 1);
			}
		}

		solve(ustr, 0, unique, "", 0, k);

	}

	// on level we are putting characters.
	// we are generating the combinations not permutations, bcoz on level we are
	// putting characters so first
	// a will come then b then c.

	public static void solve(String ustr, int idx, HashMap<Character, Integer> unique, String asf, int ssf, int ts) {

		if (ssf > ts) {
			return;
		}

		if (idx == ustr.length()) {
			if (ssf == ts) {
				System.out.println(asf);
			}
			return;
		}

		char ch = ustr.charAt(idx);
		for (int i = unique.get(ch); i >= 0; i--) {

			String str = "";
			for (int j = 0; j < i; j++) {
				str += ch;
			}

			solve(ustr, idx + 1, unique, asf + str, ssf + i, ts);

		}

	}

}
