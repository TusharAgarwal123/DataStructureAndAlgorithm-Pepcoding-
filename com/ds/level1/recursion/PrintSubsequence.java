package com.ds.level1.recursion;

import java.util.Scanner;

public class PrintSubsequence {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		printSS(str, "");
	}

	public static void printSS(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = str.charAt(0);

		printSS(str.substring(1), ans + ch);
		printSS(str.substring(1), ans);

	}

}
