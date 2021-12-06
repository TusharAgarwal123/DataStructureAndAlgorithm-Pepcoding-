package com.ds.level1.basic;

public class SieveOfEratosthenes {

	// this algorithm is use to find prime no till n.
	public static void main(String[] args) {

		int n = 30;
		boolean ar[] = new boolean[n + 1];

		for (int i = 2; i * i < ar.length; i++) {
			if (ar[i] == false) {
				for (int j = i; j * i < ar.length; j++) {
					ar[j * i] = true;
				}
			}
		}

		for (int i = 2; i < ar.length; i++) {
			if (ar[i] == false) {
				System.out.println(i);
			}
		}

	}

}
