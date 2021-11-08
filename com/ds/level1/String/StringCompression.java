package com.ds.level1.String;

import java.util.Scanner;

/*
 * 1. You are given a string. 
2. You have to compress the given string in the following two ways - 
   First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
   For "aaabbccdee", the compressed string will be "abcde".
   Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
   For "aaabbccdee", the compressed string will be "a3b2c2de2".

 */

public class StringCompression {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

	public static String compression1(String str) {

		String s = str.substring(0, 1);
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				s = s + str.charAt(i);
			}
		}

		return s;
	}

	public static String compression2(String str) {

		String s = str.substring(0, 1);
		int c = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				if (c > 1) {
					s = s + c;
				}
				s = s + str.charAt(i);
				c = 1;
			} else {
				c++;
			}
		}
		if (c > 1) {
			s = s + c;
		}

		return s;
	}

}
