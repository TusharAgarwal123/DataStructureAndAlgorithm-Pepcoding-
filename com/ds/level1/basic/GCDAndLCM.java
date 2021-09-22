package com.ds.level1.basic;

public class GCDAndLCM {

	public static void main(String[] args) {

		int n1 = 6;
		int n2 = 8;

		int temp1 = n1;
		int temp2 = n2;

		while (temp1 % temp2 != 0) {
			int rem = temp1 % temp2;
			temp1 = temp2;
			temp2 = rem;
		}

		int gcd = temp2;

		int lcm = (n1 * n2) / gcd;

		System.out.println(gcd);
		System.out.println(lcm);

	}

}
