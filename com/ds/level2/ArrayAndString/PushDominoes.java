package com.ds.level2.ArrayAndString;

//838. Push Dominoes

public class PushDominoes {

	public String pushDominoes(String dominoes) {

		dominoes = "L" + dominoes + "R";

		int pi = 0;
		char[] arr = dominoes.toCharArray();

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 'L') {

				if (arr[pi] == 'L') {

					for (int x = pi; x < i; x++) {
						arr[x] = 'L';
					}

				} else if (arr[pi] == 'R') {

					int lo = pi + 1;
					int hi = i - 1;
					while (lo < hi) {
						arr[lo] = 'R';
						arr[hi] = 'L';
						lo++;
						hi--;
					}

				}

				pi = i;

			} else if (arr[i] == 'R') {

				if (arr[pi] == 'L') {

					// do nothing

				} else if (arr[pi] == 'R') {
					for (int x = pi + 1; x < i; x++) {
						arr[x] = 'R';
					}
				}

				pi = i;

			}

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < arr.length - 1; i++) {
			sb.append(arr[i]);
		}

		return sb.toString();

	}

}
