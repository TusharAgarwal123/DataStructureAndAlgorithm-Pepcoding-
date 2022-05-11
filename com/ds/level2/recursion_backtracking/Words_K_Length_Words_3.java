package com.ds.level2.recursion_backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 1. You are given a word (may have one character repeat more than once).
2. You are given an integer k.
3. You are required to generate and print all k length words by using chars of the word.
 */
public class Words_K_Length_Words_3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int k = Integer.parseInt(br.readLine());

		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : str.toCharArray()) {
			map.put(ch, -1);
		}

		solve(str, 0, map, new Character[k], 0, k);

	}

	public static void solve(String str, int i, HashMap<Character, Integer> map, Character spot[], int ssf, int ts) {

		if (i == str.length()) {
			if (ssf == ts) {
				for (char ch : spot) {
					System.out.print(ch);
				}
				System.out.println();
			}

			return;
		}

		char ch = str.charAt(i);
		int lo = map.get(ch);

		for (int j = lo + 1; j < spot.length; j++) {
			if (spot[j] == null) {
				spot[j] = ch;
				map.put(ch, j);
				solve(str, i + 1, map, spot, ssf + 1, ts);
				spot[j] = null;
				map.put(ch, lo);
			}
		}

		if (lo == -1) {
			solve(str, i + 1, map, spot, ssf, ts);
		}

	}

}
