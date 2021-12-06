package com.ds.level1.binarySearch;

public class NextAlphabeticalElement {

	/*
	 * this problem is same as ceil but here alphabetic are given. but difference is
	 * that if any letter is present then also we have to return the next letter.
	 */

	public static void main(String[] args) {

		char[] ch = { 'c', 'e', 'h', 'k', 'n' };
		char c = 'j';
		int l = 0;
		int r = ch.length - 1;

		System.out.println(find(ch, l, r, c));

	}

	private static char find(char[] ch, int l, int r, char c) {

		char ans = 0;
		int mid = 0;
		while (l <= r) {

			mid = l + (r - l) / 2;

			if (ch[mid] == c) {
				l = mid + 1;
			}

			else if (ch[mid] > c) {
				ans = ch[mid];
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ans;

	}
}
