package com.ds.level1.recursion2;

import java.util.HashSet;

public class Permutation {

	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) {

//		permutation("", "abc");
//		System.out.println(set);

//		System.out.println(permutation2("abc", ""));
//
//		permutationWithSpaces("abc", "");

//		permutationWithCaseChange("abc", "");
		letterCasePermutation("a1B2", "");

	}

	static void permutation(String s1, String s2) {

		if (s2.isEmpty()) {
			System.out.println(s1);
			set.add(s1);
			return;
		}

		char ch = s2.charAt(0);
		s2 = s2.substring(1);
		for (int i = 0; i <= s1.length(); i++) {

			String first = s1.substring(0, i);
			String second = s1.substring(i);
			permutation(first + ch + second, s2);

		}

	}

	static int permutation2(String s1, String ans) {

		if (s1.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int c = 0;
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			c += permutation2(s1.substring(0, i) + s1.substring(i + 1), ans + ch);
		}
		return c;
	}

	static void permutationWithSpaces(String s1, String s2) {

		work(s1.substring(1), s2 + s1.charAt(0));

	}

	static void work(String s1, String s2) {

		if (s1.isEmpty()) {
			System.out.println(s2);
			return;
		}

		char ch = s1.charAt(0);
		s1 = s1.substring(1);

		work(s1, s2 + "_" + ch);
		work(s1, s2 + ch);

	}

	public static void permutationWithCaseChange(String s1, String s2) {

		if (s1.isEmpty()) {
			System.out.println(s2);
			return;
		}

		permutationWithCaseChange(s1.substring(1), s2 + s1.charAt(0));
		permutationWithCaseChange(s1.substring(1), s2 + (char) (s1.charAt(0) - 32));

	}

	public static void letterCasePermutation(String s1, String s2) {

		if (s1.isEmpty()) {
			System.out.println(s2);
			return;
		}

		char ch = s1.charAt(0);
		s1 = s1.substring(1);

		if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) { // if it is alphabet.

			letterCasePermutation(s1, s2 + ch);
			if (ch >= 65 && ch <= 90) {
				letterCasePermutation(s1, s2 + (char) (ch + 32));
			} else {
				letterCasePermutation(s1, s2 + (char) (ch - 32));
			}
		} else {
			letterCasePermutation(s1, s2 + ch);
		}

	}

}
