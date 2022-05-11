package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all ways you can select k characters out of the word.
 */
public class Words_K_Selection_4 {

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

		solve(ustr, 1, k, unique, "", 0);

	}

	// on level we are putting spots and in option we have characters.
	// we are generating the combinations.
	public static void solve(String ustr, int cs, int ts, HashMap<Character, Integer> unique, String asf, int lc) {

		if (cs > ts) {
			System.out.println(asf);
			return;
		}

		for (int i = lc; i < ustr.length(); i++) {

			char ch = ustr.charAt(i);
			if (unique.get(ch) > 0) {
				unique.put(ch, unique.get(ch) - 1);
				solve(ustr, cs + 1, ts, unique, asf + ch, i);
				unique.put(ch, unique.get(ch) + 1);
			}

		}

	}

}
