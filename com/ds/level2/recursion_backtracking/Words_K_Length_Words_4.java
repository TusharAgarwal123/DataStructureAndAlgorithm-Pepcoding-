package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words by using chars of the word.

 */
public class Words_K_Length_Words_4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		String ustr = "";
		HashMap<Character, Integer> map = new HashMap<>();

		for (char ch : str.toCharArray()) {

			if (!map.containsKey(ch)) {
				map.put(ch, 1);
				ustr += ch;
			} else {
				map.put(ch, map.get(ch) + 1);
			}

		}

		solve(ustr, 1, k, map, "");

	}

	// on level we are putting spots and in options we have characters.
	// on each spot, all the characters whose frequency > 0 will be check.
	public static void solve(String ustr, int cs, int ts, HashMap<Character, Integer> map, String asf) {

		if (cs > ts) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < ustr.length(); i++) {

			char ch = ustr.charAt(i);
			if (map.get(ch) > 0) {
				map.put(ch, map.get(ch) - 1);
				solve(ustr, cs + 1, ts, map, asf + ch);
				map.put(ch, map.get(ch) + 1);
			}

		}

	}

}
