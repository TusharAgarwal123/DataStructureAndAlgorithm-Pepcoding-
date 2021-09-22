package com.ds.level1.basic;

public class PythagoreanTriplet {

	public static void main(String[] args) {

		int a = 5;
		int b = 3;
		int c = 4;
		int max = a;

		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}

		if (max == a) {

			if ((a * a) == (b * b) + (c * c)) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}

		} else if (max == b) {
			if ((b * b) == (a * a) + (c * c)) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		} else {
			if ((c * c) == (a * a) + (b * b)) {
				System.out.println(true);
			} else {
				System.out.println(false);
			}
		}

	}

}
