package com.ds.level1.recursion;

public class AsciSubsequence {

	static int c = 0;

	public static void main(String[] args) {

		subsequence("", "abc");
		System.out.println(c);

	}

	static void subsequence(String s1, String s2) {

		if (s2.isEmpty()) {
			System.out.println(s1);
			c++;
			return;
		}
		char ch = s2.charAt(0);
		s2 = s2.substring(1);
		subsequence(s1 + ch, s2);
		subsequence(s1 + (int) ch, s2);
		subsequence(s1, s2);

	}

}
