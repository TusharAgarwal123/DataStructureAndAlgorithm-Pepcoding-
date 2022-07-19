package com.ds.level2.ArrayAndString;

//556. Next Greater Element III

/*
 * Given a positive integer n, find the smallest integer which has exactly the same digits existing in the
 *  integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit 
in 32-bit integer, return -1.
 */

public class NextGreaterElementIII {

	public int nextGreaterElement(int n) {

		char ar[] = (n + "").toCharArray();

		int i = ar.length - 1;

		while (i > 0) {
			if (ar[i - 1] >= ar[i]) {
				i--;
			} else {
				break;
			}
		}

		if (i == 0) {
			return -1;
		}

		int idx = i - 1;

		int j = ar.length - 1;

		while (j > idx) {
			if (ar[j] > ar[idx]) {
				break;
			}
			j--;
		}

		// swap

		char temp = ar[idx];
		ar[idx] = ar[j];
		ar[j] = temp;

		// reverse from end to i;

		int left = i;
		int right = ar.length - 1;

		while (left < right) {
			char t = ar[left];
			ar[left] = ar[right];
			ar[right] = t;
			left++;
			right--;
		}

		String str = new String(ar);

		long val = Long.parseLong(str);

		return (val > Integer.MAX_VALUE ? -1 : (int) val);

	}

}
