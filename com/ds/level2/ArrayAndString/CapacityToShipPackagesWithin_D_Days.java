package com.ds.level2.ArrayAndString;

//1011. Capacity To Ship Packages Within D Days

/*
 * A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on
 the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity
  of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being
 shipped within days days.
 */

public class CapacityToShipPackagesWithin_D_Days {

	public int shipWithinDays(int[] weights, int days) {

		int lo = Integer.MIN_VALUE;
		int hi = 0;

		for (int x : weights) {
			hi += x;
			lo = Math.max(lo, x);
		}

		while (lo < hi) {

			int mid = lo + (hi - lo) / 2;

			int capacity = mid;

			int countDays = 1;
			int currDaySum = 0;

			// calculating days require for current capacity.
			for (int num : weights) {
				if (currDaySum + num <= capacity) {
					currDaySum += num;
				} else {
					currDaySum = num;
					countDays++;
				}
			}

			if (countDays > days) {
				lo = mid + 1;
			} else {
				hi = mid;
			}

		}

		return lo;

	}

}
