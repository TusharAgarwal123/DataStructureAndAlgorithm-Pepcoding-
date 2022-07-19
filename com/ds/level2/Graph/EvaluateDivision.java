package com.ds.level2.Graph;

import java.util.HashMap;
import java.util.List;

//leetcode 399. Evaluate Division

/*
 * You are given an array of variable pairs equations and an array of real numbers values,
 *  where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a
 *   string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find 
the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero
 and that there is no contradiction.
 */

public class EvaluateDivision {

	HashMap<String, String> parent;
	HashMap<String, Double> mult;

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

		parent = new HashMap<>();
		mult = new HashMap<>();

		for (List<String> er : equations) {
			addToDSU(er.get(0));
			addToDSU(er.get(1));
		}

		int i = 0;
		for (List<String> er : equations) {
			String l0 = find(er.get(0));
			String l1 = find(er.get(1));

			double m0 = mult.get(er.get(0));
			double m1 = mult.get(er.get(1));
			parent.put(l0, l1);

			// this is most important line understand it by doing dry run.
			mult.put(l0, values[i] * m1 / m0);

			i++;

		}

		double[] res = new double[queries.size()];

		i = 0;

		for (List<String> qr : queries) {

			String q0 = qr.get(0);
			String q1 = qr.get(1);

			if (parent.containsKey(q0) == false || parent.containsKey(q1) == false) {
				res[i] = -1;
				i++;
				continue;
			}

			String l0 = find(q0);
			String l1 = find(q1);

			if (l0.equals(l1) == false) { // if both belongs to different set.
				res[i] = -1;
				i++;
				continue;
			}

			double m0 = mult.get(q0);
			double m1 = mult.get(q1);

			res[i] = m0 / m1;

			i++;

		}

		return res;

	}

	void addToDSU(String x) {

		if (parent.containsKey(x) == false) {
			parent.put(x, x);
			mult.put(x, 1.0);
		}

	}

	String find(String x) {
		if (parent.get(x).equals(x)) {
			return x;
		} else {
			String cp = parent.get(x);
			String fp = find(cp);

			parent.put(x, fp);
			mult.put(x, mult.get(cp) * mult.get(x));

			return fp;
		}
	}

}
