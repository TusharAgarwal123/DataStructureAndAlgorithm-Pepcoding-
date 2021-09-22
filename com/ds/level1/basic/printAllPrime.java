package com.ds.level1.basic;

public class printAllPrime {

	public static void main(String[] args) {
		int low = 3;
		int high = 17;

		for (int x = low; x <= high; x++) {

			boolean isPrime = true;
			for (int div = 2; div * div <= x; div++) {
				int rem = x % div;
				if (rem == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime == true) {
				System.out.println(x);
			}

		}
	}

}
