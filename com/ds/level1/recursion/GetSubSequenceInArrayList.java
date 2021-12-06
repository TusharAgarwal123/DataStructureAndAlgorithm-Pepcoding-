package com.ds.level1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSubSequenceInArrayList {

	public static void main(String[] args) throws Exception {

		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(gss(str));

	}

	public static ArrayList<String> gss(String str) {

		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		char ch = str.charAt(0);

		ArrayList<String> res = gss(str.substring(1));
		ArrayList<String> mres = new ArrayList<>();
		for (String val : res) {
			mres.add("" + val);
		}
		for (String val : res) {
			mres.add(ch + val);
		}

		return mres;
	}

	static ArrayList<String> subsequence2(String s1) {

		if (s1.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add("");
			return list;
		}

		char ch = s1.charAt(0);

		ArrayList<String> my = new ArrayList<String>();
		ArrayList<String> cur = subsequence2(s1.substring(1));

		for (String str : cur) {
			if (!my.contains(str)) { // for uniqueness.
				my.add(str);
			}
			if (!my.contains(ch + str)) {
				my.add(ch + str);
			}
		}

		return my;

	}

}
