package com.ds.level2.ArrayAndString;

//134. Gas Station

/*
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to 
its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around
 the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is
  guaranteed to be unique
 */

public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int csum = 0;
		int osum = 0;
		int si = 0;

		for (int i = 0; i < gas.length; i++) {
			int delta = gas[i] - cost[i];

			osum += delta;
			csum += delta;

			if (csum < 0) {
				csum = 0;
				si = i + 1;
			}
		}

		if (osum >= 0) {
			return si;
		} else {
			return -1;
		}

	}

}
