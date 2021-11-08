package com.ds.level1.recursion;

import java.util.Scanner;

/*
 * 1. You are given a string str of digits. (will never start with a 0)
2. You are required to encode the str as per following rules
    1 -> a
    2 -> b
    3 -> c
    ..
    25 -> y
    26 -> z
3. Complete the body of printEncodings function - without changing signature - to calculate and print all encodings of str.
 */

public class PrintEncodings {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		printEncodings(str, "");

	}

	public static void printEncodings(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
			return;
		} else if (str.length() == 1) {
			char ch = str.charAt(0);
			if (ch == '0') {
				return;
			} else {
				int chv = ch - '0';
				char code = (char) ('a' + chv - 1);
				printEncodings(str.substring(1), ans + code);
			}
		} else {
			char ch1 = str.charAt(0);
			if (ch1 == '0') {
				return;
			} else {
				int ch1v = ch1 - '0';
				char code = (char) ('a' + ch1v - 1);
				printEncodings(str.substring(1), ans + code);
			}

			String ch2 = str.substring(0, 2);
			int ch2v = Integer.parseInt(ch2);
			if (ch2v <= 26) {
				char code = (char) ('a' + ch2v - 1);
				printEncodings(str.substring(2), ans + code);
			}

		}

	}

}
