package com.ds.level2.DP;

import java.util.ArrayList;
import java.util.List;

//131. Palindrome Partitioning

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all
 *  possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.
 */

public class PalindromePartitioning {

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
			if (isPalindrome(left)) {
				String right = str.substring(i + 1);
				list.add(left);
				solve(right, new ArrayList<>(list));
				list.remove(list.size() - 1);
			}
		}

	}

	public boolean isPalindrome(String str) {
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

}
