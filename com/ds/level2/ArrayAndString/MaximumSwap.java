package com.ds.level2.ArrayAndString;

//670. Maximum Swap

/*
 *You are  given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.
 */

public class MaximumSwap {

	public int maximumSwap(int num) {

		char ar[] = (num + "").toCharArray();

		int right[] = new int[ar.length];

		right[ar.length - 1] = -1;

		for (int i = ar.length - 2; i >= 0; i--) {
			if (i == ar.length - 2) {
				right[i] = ar.length - 1;
			} else {
				if (ar[i + 1] > ar[right[i + 1]]) {
					right[i] = i + 1;
				} else {
					right[i] = right[i + 1];
				}
			}
		}

		for (int i = 0; i < ar.length - 1; i++) {
			if (ar[i] < ar[right[i]]) {
				char temp = ar[i];
				ar[i] = ar[right[i]];
				ar[right[i]] = temp;
				break;
			}
		}

		return Integer.parseInt(new String(ar));

	}

}
