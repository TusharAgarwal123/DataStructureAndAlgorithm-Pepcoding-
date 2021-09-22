package com.ds.level1.basic;

public class InverseOfNumber {

	public static void main(String[] args) {

		int n = 21543;

		int p = 1;
		int inv = 0;
		while (n != 0) {
			int rem = n % 10;
			n = n / 10;
			inv += p * (int) Math.pow(10, rem - 1);
			p++;
		}

		System.out.println(inv);
	}

}
