package com.ds.level2.recursion_backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllPalindromicPartitions {

	public static void solution(String str, String asf) {
		// write you code here

		if (str.length() == 0) {
			System.out.println(asf);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i + 1);
			if (isPalindromic(left)) {
				String right = str.substring(i + 1);
				solution(right, asf + "(" + left + ") ");
			}

		}

	}

	public static boolean isPalindromic(String str) {

		if (str.length() == 1) {
			return true;
		}

		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

	// leetcode 131.
	List<List<String>> ans;

	public List<List<String>> partition(String s) {

		ans = new ArrayList<>();
		solve(s, new ArrayList<String>());
		return ans;

	}

	public void solve(String str, List<String> list) {

		if (str.length() == 0) {
			ans.add(list);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			String left = str.substring(0, i + 1);
			if (isPalindromic(left)) {
				String right = str.substring(i + 1);
				list.add(left);
				solve(right, new ArrayList<>(list));
				list.remove(list.size() - 1);
			}
		}

	}

}
