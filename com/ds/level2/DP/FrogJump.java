package com.ds.level2.DP;

import java.util.HashMap;
import java.util.HashSet;

//403. Frog Jump

/*
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may
 *  or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the
 river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must
  be 1 unit.

If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only
 jump in the forward direction.
 
 */

public class FrogJump {

	public boolean canCross(int[] stones) {

		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

		for (int stone : stones) {
			map.put(stone, new HashSet<Integer>());
		}

		map.get(0).add(1);

		for (int i = 0; i < stones.length - 1; i++) {
			int stone = stones[i];
			for (int step : map.get(stone)) {
				int reach = stone + step;

				if (reach == stones[stones.length - 1]) {
					return true;
				} else if (map.containsKey(reach)) {
					HashSet<Integer> steps = map.get(reach);
					if (step - 1 > 0) {
						steps.add(step - 1);
					}
					steps.add(step);
					steps.add(step + 1);
				}
			}
		}

		return false;

	}

}
