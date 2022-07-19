package com.ds.level2.Graph;

import java.util.ArrayList;
import java.util.List;

//1627. Graph Connectivity With Threshold

public class GraphConnectivityWithThreshold {

	public List<Boolean> areConnected(int n, int threshold, int[][] queries) {

		p = new int[n + 1];
		r = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			p[i] = i;
			r[i] = 0;
		}

		for (int div = threshold + 1; div <= n; div++) {
			for (int m = 1; div * m <= n; m++) {
				union(div, div * m);
			}
		}

		List<Boolean> res = new ArrayList<>();

		for (int qr[] : queries) {
			int n1 = qr[0];
			int n2 = qr[1];

			boolean flag = (find(n1) == find(n2));

			res.add(flag);
		}

		return res;

	}

	int p[];
	int r[];

	public int find(int x) {
		if (p[x] == x) {
			return x;
		} else {
			p[x] = find(p[x]);
			return p[x];
		}
	}

	public void union(int x, int y) {

		int xl = find(x);
		int yl = find(y);

		if (xl == yl) {
			return;
		}

		if (r[xl] < r[yl]) {
			p[xl] = yl;
		} else if (r[yl] < r[xl]) {
			p[yl] = xl;
		} else {
			p[xl] = yl;
			r[yl]++;
		}

	}

}
