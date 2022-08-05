package com.ds.level2.ArrayAndString;

//875. Koko Eating Bananas

/*
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards
 *  have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and 
eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will
 not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.


 */

public class KokoEatingBananas {

	public int minEatingSpeed(int[] piles, int h) {

		int lo = 1;
		int hi = Integer.MIN_VALUE;

		for (int x : piles) {
			hi = Math.max(hi, x);
		}

		while (lo < hi) {

			int mid = lo + (hi - lo) / 2;

			// calculate hours.

			int totalTime = 0;
			for (int pile : piles) {
				int time = (pile + mid - 1) / mid; // calculating the ceil value.
				totalTime += time;
			}

			if (totalTime > h) {
				lo = mid + 1;
			} else {
				hi = mid;
			}

		}

		return lo;

	}

}
