package com.ds.level2.ArrayAndString;

//345. Reverse Vowels of a String

/*
 * Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 */

public class ReverseVowelsAfAString {

	public String reverseVowels(String s) {

		StringBuilder sb = new StringBuilder(s);

		int left = 0;
		int right = sb.length() - 1;

		while (left < right) {

			while (left < right && "aeiouAEIOU".indexOf(s.charAt(left)) == -1) {
				left++;
			}

			while (left < right && "aeiouAEIOU".indexOf(s.charAt(right)) == -1) {
				right--;
			}

			char lch = sb.charAt(left);
			char rch = sb.charAt(right);

			sb.setCharAt(left, rch);
			sb.setCharAt(right, lch);

			left++;
			right--;

		}

		return sb.toString();

	}

}
