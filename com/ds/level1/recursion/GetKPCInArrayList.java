package com.ds.level1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
2. The following list is the key to characters map :
    0 -> .;
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqrs
    7 -> tu
    8 -> vwx
    9 -> yz
3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be produced by the keys in str.
 */
public class GetKPCInArrayList {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(getKPC(str));

	}

	static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

	public static ArrayList<String> getKPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		char ch = str.charAt(0);

		ArrayList<String> res = getKPC(str.substring(1));
		ArrayList<String> mres = new ArrayList<>();

		String code = codes[ch - '0'];

		for (int i = 0; i < code.length(); i++) {
			char chh = code.charAt(i);
			for (String ss : res) {
				mres.add(chh + ss);
			}
		}

		return mres;

	}

}
