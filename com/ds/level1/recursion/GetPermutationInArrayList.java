package com.ds.level1.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPermutationInArrayList {

	public static void main(String[] args) {
		System.out.println("Enter the String");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(permutation(str));
	}

	static ArrayList<String> permutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}

		char ch = str.charAt(0);
		ArrayList<String> res = permutation(str.substring(1));
		ArrayList<String> mres = new ArrayList<>();

		for (String val : res) {
			for (int i = 0; i <= val.length(); i++) {
				mres.add(val.substring(0, i) + ch + val.substring(i));
			}
		}

		return mres;
	}

}
