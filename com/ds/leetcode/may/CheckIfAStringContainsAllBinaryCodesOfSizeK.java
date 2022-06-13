package com.ds.leetcode.may;

import java.util.HashSet;

//1461. Check If a String Contains All Binary Codes of Size K
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {

	public boolean hasAllCodes(String s, int k) {

		int len = s.length();
		int pow = 1 << k;

		HashSet<String> set = new HashSet<>();

		for (int i = 0; i <= len - k; i++) {
			set.add(s.substring(i, i + k));
		}

		return set.size() == pow ? true : false;

	}

}
