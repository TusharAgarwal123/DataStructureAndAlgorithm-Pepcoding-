package com.ds.level2.ArrayAndString;

//754. Reach a Number

/*
 * You are standing at position 0 on an infinite number line. There is a destination at position target.

You can make some number of moves numMoves so that:

On each move, you can either go left or right.
During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach 
the destination.
 */

public class ReachANumber {

	public int reachNumber(int target) {

		int x = 0;
		target = Math.abs(target);

		while (true) {
			int range = x * (x + 1) / 2;
			if (range >= target && range % 2 == target % 2) {
				break;
			}
			x++;
		}

		return x;

	}

}
