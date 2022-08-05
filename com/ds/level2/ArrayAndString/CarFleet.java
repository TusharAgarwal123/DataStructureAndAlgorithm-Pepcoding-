package com.ds.level2.ArrayAndString;

import java.util.PriorityQueue;

//853. Car Fleet

public class CarFleet {

	public int carFleet(int target, int[] position, int[] speed) {

		PriorityQueue<Car> pq = new PriorityQueue<>();

		for (int i = 0; i < position.length; i++) {
			Car c = new Car(position[i], speed[i]);
			pq.add(c);
		}

		int group = 0;
		double time = 0;

		while (pq.size() > 0) {
			Car c = pq.remove();

			double ctime = (target - c.pos) * 1.0 / c.speed;

			if (ctime > time) {
				time = ctime;
				group++;
			}
		}

		return group;

	}

	class Car implements Comparable<Car> {
		int pos;
		int speed;

		Car(int p, int s) {
			this.pos = p;
			this.speed = s;
		}

		public int compareTo(Car c) {
			return c.pos - this.pos; // largest position car come first.
		}
	}

}
