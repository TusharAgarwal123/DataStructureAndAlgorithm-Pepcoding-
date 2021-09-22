package com.ds.level1.basic;

public class CountDigitInNumber {
	public static void main(String[] args) {

		int n = 12345;

		int c = 0;
		while (n != 0) {
			n = n / 10;
			c++;
		}

		System.out.println(c);

	}

}
