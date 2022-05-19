package com.ds.level2.recursion_backtracking;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 1. You are given a string of length n.
2. You have to print all the palindromic permutations of the given string.
3. If no palindromic permutation exists for the given string, print "-1".
 */
public class AllPalindromicPermutations {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}

		Character oc = null;
		int ol = 0;
		int len = 0;

		for (char ch : fmap.keySet()) {
			int fr = fmap.get(ch);
			if (fr % 2 == 1) {
				oc = ch;
				ol++;
			}

			fmap.put(ch, fr / 2);
			len += fr / 2;
		}

		if (ol > 1) {
			System.out.println(-1);
			return;
		}

		solve(1, len, fmap, oc, "");

		// write your code here
	}

	public static void solve(int cs, int ts, HashMap<Character, Integer> fmap, Character oc, String asf) {

		if (cs > ts) {
			StringBuilder sb = new StringBuilder();
			for (int i = asf.length() - 1; i >= 0; i--) {
				sb.append(asf.charAt(i));
			}

			String ans = asf;
			if (oc != null) {
				ans += oc;
			}

			ans += sb.toString();

			System.out.println(ans);
			return;

		}

		for (char ch : fmap.keySet()) {
			int fr = fmap.get(ch);
			if (fr > 0) {
				fmap.put(ch, fr - 1);
				solve(cs + 1, ts, fmap, oc, asf + ch);
				fmap.put(ch, fr);
			}
		}

	}

}
