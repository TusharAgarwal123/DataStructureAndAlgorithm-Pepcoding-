package com.ds.level1.recursion;

import java.util.Scanner;

public class PrintKPC {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		printKPC(str, "");

	}

	static String rs[] = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static void printKPC(String str, String ans) {

		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = str.charAt(0);
		String val = rs[ch - '0'];

		for (int i = 0; i < val.length(); i++) {

			char cc = val.charAt(i);
			printKPC(str.substring(1), ans + cc);

		}

	}

}
