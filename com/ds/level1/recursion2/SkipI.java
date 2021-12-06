package com.ds.level1.recursion2;

public class SkipI {

	public static void main(String[] args) {

		skipi("", "iabidiiwi");

	}

	static void skipi(String s, String s2) {

		if (s2.isEmpty()) {
			System.out.println(s);
			return;
		}

		char ch = s2.charAt(0);
		if (ch == 'i') {
			skipi(s, s2.substring(1));
		} else {
			skipi(s + ch, s2.substring(1));
		}
	}

}
