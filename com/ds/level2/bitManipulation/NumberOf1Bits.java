package com.ds.level2.bitManipulation;

/*
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input 
will be given as a signed integer type. It should not affect your implementation, as the integer's 
internal binary representation is the same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore,
 in Example 3, the input represents the signed integer. -3.
 */

//191. Number of 1 Bits
public class NumberOf1Bits {

	// O(1)
	public int hammingWeight(int n) {

		int c = 0;
		while (n != 0) {
			n = n & (n - 1);
			c++;
		}

		return c;

	}

	// O(32)
	public int hammingWeight2(int n) {

		int c = 0;
		int mask = 1;
		for (int i = 1; i <= 32; i++) {
			int ans = (n & mask);
			if (ans != 0) {
				c++;
			}

			mask = mask << 1;

		}

		return c;

	}

}
