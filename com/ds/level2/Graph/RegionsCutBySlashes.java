package com.ds.level2.Graph;

//leetcode 959. Regions Cut By Slashes

/*
 * An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or
 *  blank space ' '. These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.


 */

public class RegionsCutBySlashes {

	public int regionsBySlashes(String[] grid) {

		parent = new int[4 * grid.length * grid.length];
		rank = new int[4 * grid.length * grid.length];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length(); j++) {
				char ch = grid[i].charAt(j);

				int bno = i * grid.length + j;

				int cno0 = 4 * bno + 0;
				int cno1 = 4 * bno + 1;
				int cno2 = 4 * bno + 2;
				int cno3 = 4 * bno + 3;

				if (ch != '/') {
					unionHelper(cno0, cno1);
					unionHelper(cno2, cno3);
				}

				if (ch != '\\') {
					unionHelper(cno0, cno3);
					unionHelper(cno1, cno2);
				}

				if (i > 0) {
					int obno = (i - 1) * grid.length + j;
					unionHelper(4 * bno + 0, 4 * obno + 2);
				}

				if (j > 0) {
					int obno = i * grid.length + (j - 1);
					unionHelper(4 * bno + 3, 4 * obno + 1);
				}

//	                 if(i<grid.length-1){
//	                     int obno=(i+1)*grid.length+j;
//	                     unionHelper(4*bno+2,4*obno+0);
//	                 }

//	                 if(j<grid[0].length()-1){
//	                     int obno=i*grid.length+(j+1);
//	                     unionHelper(4*bno+1,4*obno+3);
//	                 }

			}
		}

		int count = 0;

		for (int i = 0; i < parent.length; i++) {
			if (parent[i] == i) {
				count++;
			}
		}

		return count;

	}

	int parent[];
	int rank[];

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}

	public void union(int v1, int v2) {
		if (rank[v1] < rank[v2]) {
			parent[v1] = v2;
		} else if (rank[v2] < rank[v1]) {
			parent[v2] = v1;
		} else {
			parent[v1] = v2;
			rank[v2]++;
		}
	}

	public void unionHelper(int x, int y) {

		int x1 = find(x);
		int y1 = find(y);

		if (x1 != y1) {
			union(x1, y1);
		}

	}

}
