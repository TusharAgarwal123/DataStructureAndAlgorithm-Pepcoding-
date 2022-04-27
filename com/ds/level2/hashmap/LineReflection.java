package com.ds.level2.hashmap;

import java.util.HashSet;

/*
 * Given n points on a 2D plane, find if there is such a line parallel 
 * to y-axis that reflect the given points symmetrically, in other words,
 *  answer whether or not if there exists a line that after reflecting all
 *   points over the given line the set of the original points is the same that the reflected ones.

Note that there can be repeated points.
 */
public class LineReflection {

	public static boolean isReflected(int[][] points) {
		// Code Here

		HashSet<String> set = new HashSet<>();
		int xmin = points[0][0];
		int xmax = points[0][0];

		set.add(points[0][0] + "#" + points[0][1]);

		for (int i = 1; i < points.length; i++) {

			xmin = Math.min(xmin, points[i][0]);
			xmax = Math.max(xmax, points[i][0]);

			set.add(points[i][0] + "#" + points[i][1]);

		}

		int xmirror = (xmin + xmax) / 2;

		for (int i = 0; i < points.length; i++) {

			int x = points[i][0];
			int y = points[i][1];

			int ymir = y;
			int xmir = (2 * xmirror) - x;

			if (!set.contains(xmir + "#" + ymir)) {
				return false;
			}

		}

		return true;

	}

}
