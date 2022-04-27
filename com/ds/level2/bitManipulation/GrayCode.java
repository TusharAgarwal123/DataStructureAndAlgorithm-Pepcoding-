package com.ds.level2.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/*
 * 1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
     sequence of gray code. A gray code sequence must begin with 0.
 
 Example:
 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 [0,2,3,1] is also a valid gray code sequence.
 00 - 0
 10 - 2
 11 - 3
 01 - 1
 */

//89. Gray Code
public class GrayCode {

	public static List<Integer> grayCode(int n) {
		// Write your code here

		if (n == 0) {
			List<Integer> ans = new ArrayList<>();
			ans.add(0);
			return ans;
		}

		if (n == 1) {
			List<Integer> ans = new ArrayList<>();
			ans.add(0);
			ans.add(1);
			return ans;
		}

		List<Integer> rres = grayCode(n - 1);
		List<Integer> mres = new ArrayList<>();

		for (int i = 0; i < rres.size(); i++) {
			mres.add(rres.get(i));
		}

		for (int i = rres.size() - 1; i >= 0; i--) {
			int val = rres.get(i);
			int bm = (1 << (n - 1));

			val = val | bm;

			mres.add(val);
		}

		return mres;

	}

}
