package com.ds.leetcode.may;

import java.util.ArrayList;
import java.util.List;

//leetcode 17. Letter Combinations of a Phone Number
public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations(String digits) {

		if (digits.length() == 0) {
			return new ArrayList<String>();
		}

		return solve(digits);

	}

	String[] code = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> solve(String digits) {

		if (digits.length() == 0) {
			List<String> ll = new ArrayList<>();
			ll.add("");
			return ll;

		}

		char ch = digits.charAt(0);
		int idx = ch - '0';
		String str = code[idx - 2];
		List<String> res = solve(digits.substring(1));

		List<String> mres = new ArrayList<>();
		for (char c : str.toCharArray()) {
			for (String ss : res) {
				mres.add(c + ss);
			}
		}

		return mres;

	}

}
