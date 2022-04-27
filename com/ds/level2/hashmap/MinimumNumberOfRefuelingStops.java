package com.ds.level2.hashmap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * A car travels from a starting position to a destination which is target miles east of the starting position.

There are gas stations along the way. The gas stations are represented as an array stations
 where stations[i] = [positioni, fueli] indicates 
that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.

The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
 It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may
  stop and refuel, transferring all the gas from the station into the car.

Return the minimum number of refueling stops the car must make in order to reach its destination.
 If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
 If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 */

//871. Minimum Number of Refueling Stops
public class MinimumNumberOfRefuelingStops {

	public int minRefuelStops(int target, int startFuel, int[][] stations) {

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		int start = startFuel;
		int i = 0;

		int pumps = 0;

		while (start < target) {

			while (i < stations.length) {
				if (stations[i][0] <= start) {
					queue.add(stations[i][1]);
				} else {
					break;
				}
				i++;
			}

			if (queue.size() == 0) {
				return -1;
			}
			start += queue.remove();

			pumps++;

		}

		return pumps;

	}

}
