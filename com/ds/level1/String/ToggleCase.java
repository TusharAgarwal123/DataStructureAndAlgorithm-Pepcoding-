package com.ds.level1.String;

import java.util.Scanner;

public class ToggleCase {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(toggleCase(str));
	}

	public static String toggleCase(String str) {
		// write your code here
		StringBuilder sb = new StringBuilder(str);

		for (int i = 0; i < sb.length(); i++) {
			char ch = sb.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				char nch = (char) ('A' + ch - 'a');
				sb.setCharAt(i, nch);
			} else if (ch >= 'A' && ch <= 'Z') {
				char nch = (char) ('a' + ch - 'A');
				sb.setCharAt(i, nch);
			}
		}
		return sb.toString();
	}

}
