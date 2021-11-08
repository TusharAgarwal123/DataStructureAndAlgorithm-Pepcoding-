package com.ds.level1.String;

import java.util.Scanner;

/*
 * 1. You are given a string. 
2. You have to print all palindromic substrings of the given string.
 */

public class AllPalindromicSubstring {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}

	public static void solution(String str) {
		// write your code here

		for (int i = 0; i < str.length(); i++) {

			for (int j = i + 1; j <= str.length(); j++) {

				boolean flag = isPalindrome(str.substring(i, j));
				if (flag == true) {
					System.out.println(str.substring(i, j));
				}
			}
		}

	}

	public static boolean isPalindrome(String str) {

		int li = 0;
		int ri = str.length() - 1;

		while (li < ri) {
			if (str.charAt(li) == str.charAt(ri)) {
				li++;
				ri--;
			} else {
				return false;
			}
		}

		return true;

	}

}
