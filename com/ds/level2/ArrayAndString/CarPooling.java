package com.ds.level2.ArrayAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//1094. Car Pooling

/*
 * There is a car with capacity empty seats. The vehicle only drives east (i.e., it cannot turn around and
 *  drive west).

You are given the integer capacity and an array trips where trips[i] = [numPassengersi, fromi, toi] indicates
 that the ith trip has numPassengersi passengers and the locations to pick them up and drop them off are fromi and toi respectively. The locations are given as the number of kilometers due east from the car's initial location.

Return true if it is possible to pick up and drop off all passengers for all the given trips, or false 
otherwise.
 */

public class CarPooling {

	public boolean carPooling(int[][] trips, int capacity) {

		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> stops = new ArrayList<>();

		for (int trip[] : trips) {

			int people = trip[0];
			int from = trip[1];
			int to = trip[2];

			if (map.containsKey(from) == false) {
				map.put(from, people);
				stops.add(from);
			} else {
				map.put(from, map.get(from) + people);
			}

			if (map.containsKey(to) == false) {
				map.put(to, -people);
				stops.add(to);
			} else {
				map.put(to, map.get(to) - people);
			}

		}

		Collections.sort(stops);
		int pic = 0;
		for (int stop : stops) {
			int delta = map.get(stop);
			pic += delta;

			if (pic > capacity) {
				return false;
			}
		}

		return true;

	}

}
