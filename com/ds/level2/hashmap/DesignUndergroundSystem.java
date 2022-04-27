package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * An underground railway system is keeping track of customer travel times
 *  between different stations. They are using this data to calculate the
 *   average time it takes to travel from one station to another.

Implement the UndergroundSystem class:

void checkIn(int id, string stationName, int t)
A customer with a card ID equal to id, checks in at the station stationName at time t.
A customer can only be checked into one place at a time.
void checkOut(int id, string stationName, int t)
A customer with a card ID equal to id, checks out from the station stationName at time t.
double getAverageTime(string startStation, string endStation)
Returns the average time it takes to travel from startStation to endStation.
The average time is computed from all the previous traveling times from startStation
 to endStation that happened directly, meaning a check in at startStation followed by
  a check out from endStation.
The time it takes to travel from startStation to endStation may be different from the
 time it takes to travel from endStation to startStation.
There will be at least one customer that has traveled from startStation to endStation
 before getAverageTime is called.
You may assume all calls to the checkIn and checkOut methods are consistent. If a
 customer checks in at time t1 then checks out at time t2, then t1 < t2. All events
  happen in chronological order.
 */

//leetcode 1396.
//Time Complexity => O(1)
//Space Complexity => O(n+m), n=no of arrivals and m=no of averages.
public class DesignUndergroundSystem {

	private Map<Integer, Event> arrivals;
	private Map<String, Average> averages;

	public DesignUndergroundSystem() {
		this.arrivals = new HashMap<>();
		this.averages = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {

		arrivals.put(id, new Event(id, stationName, t));

	}

	public void checkOut(int id, String stationName, int t) {
		Event arrivalEvent = arrivals.get(id);
		arrivals.remove(id);

		int diff = t - arrivalEvent.time;
		String key = arrivalEvent.stationName + "," + stationName;

		Average avg;

		if (averages.containsKey(key)) {
			avg = averages.get(key);
		} else {
			avg = new Average();
		}

		avg.updateAverage(diff);
		averages.put(key, avg);

	}

	public double getAverageTime(String startStation, String endStation) {

		String key = startStation + "," + endStation;
		return averages.get(key).getAverage();

	}

	static class Event {
		int id;
		String stationName;
		int time;

		public Event(int id, String stationName, int time) {
			this.id = id;
			this.stationName = stationName;
			this.time = time;
		}
	}

	static class Average {
		double total;
		int count;

		public Average() {

		}

		// public Average(double total,int count){
		// this.total=total;
		// this.count=count;
		// }

		public void updateAverage(int diff) {
			count++;
			total += diff;
		}

		public double getAverage() {
			return total / count;
		}
	}
}
