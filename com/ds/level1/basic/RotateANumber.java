package com.ds.level1.basic;

public class RotateANumber {

	public static void main(String[] args) {

		int n = 21543;
		int k = 3;

		int temp = n;
		int c = 0;
		while (temp != 0) {
			temp = temp / 10;
			c++;

		}

		k = k % c;
		if (k < 0) {
			k = k + c;
		}

		int div = (int) Math.pow(10, k);

		int mul = (int) Math.pow(10, c - k);

		int r = n % div;
		n = n / div;

		int ans = r * mul + n;

		System.out.println(ans);

	}

}
