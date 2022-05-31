package com.ds.leetcode.may;

//318. Maximum Product of Word Lengths

/*
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j])
 *  where the two words do not share common letters. 
 * If no such two words exist, return 0.
 */
public class MaximumProductOfWordLengths {

	// Optimized approach using bit manipulation in O(n^2) time.
	public int maxProduct(String[] words) {

		int max = Integer.MIN_VALUE;

		int mask[] = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			mask[i] = createBitMask(words[i]);
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((mask[i] & mask[j]) == 0) { // means both string have different characters.
					max = Math.max(max, (words[i].length() * words[j].length()));
				}
			}
		}

		return max == Integer.MIN_VALUE ? 0 : max;

	}

//     it will create the bit mask of each string we have a-z alphabets which are total 26,
//     we will assign alphabets to 0-25 bits, we can have 32 bits in integer.
//     if a come then we will on the 0th bit, if b come then we will on the 1st bit and so on till z,
//     if z come we will on the 25th bit.
//     like that we will create one mask for each string.

	// if string is abd the it's mask will be 1011

	public int createBitMask(String str) {

		int ans = 0;
		for (char ch : str.toCharArray()) {

			int t = ch - 'a';
			int onTthBit = 1 << t;
			ans = ans | onTthBit;

		}

		return ans;

	}

	// Brute Force Approach in O(n*n*l*l) time.
	public int maxProduct2(String[] words) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < words.length; i++) {

			int fr[] = fillArray(words[i]);

			for (int j = i + 1; j < words.length; j++) {

				boolean canCome = true;
				for (int k = 0; k < words[j].length(); k++) {
					char ch = words[j].charAt(k);
					if (fr[ch - 'a'] > 0) {
						canCome = false;
						break;
					}
				}

				if (canCome) {
					int ans = words[i].length() * words[j].length();
					max = Math.max(max, ans);
				}

			}
		}

		return max == Integer.MIN_VALUE ? 0 : max;

	}

	public int[] fillArray(String str) {

		int fr[] = new int[26];
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fr[ch - 'a']++;
		}

		return fr;

	}

}
