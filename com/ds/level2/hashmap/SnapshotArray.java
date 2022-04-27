package com.ds.level2.hashmap;

import java.util.HashMap;

/*
 * Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id

 */

//leetcode 1146.
public class SnapshotArray {

	int c;
	HashMap<Integer, Integer> map;

	HashMap<Integer, HashMap<Integer, Integer>> ans;

	public SnapshotArray(int length) {
		map = new HashMap<>();
		ans = new HashMap<>();
		c = 0;
	}

	public void set(int index, int val) {

		map.put(index, val);

	}

	public int snap() {

		HashMap<Integer, Integer> map1 = new HashMap<>(map);

		ans.put(c, map1);

		c++;

		return c - 1;

	}

	public int get(int index, int snap_id) {

		HashMap<Integer, Integer> map1 = ans.get(snap_id);

		if (map1.containsKey(index)) {
			return map1.get(index);
		}

		return 0;

	}

}

//Another Approach 
//Time complexity is same but this approach can be better in terms of space.

//class SnapshotArray {
//
//    
//
//    private int c;
//    private Map<Integer,Integer>[] snapShot;
//    
//    public SnapshotArray(int length) {
//         snapShot=new HashMap[length];
//        c=0;
//        
//        for(int i=0;i<length;i++){
//            snapShot[i]=new HashMap<>();
//        }
//    }
//    
//    public void set(int index, int val) {
//        
//     
//        snapShot[index].put(c,val);
//        
//    }
//    
//    public int snap() {
//        
//        
//      return c++;
//        
//    }
//    
//    public int get(int index, int snap_id) {
//        
//        for(int sidx=snap_id;sidx>=0;sidx--){
//        if(snapShot[index].containsKey(sidx)){
//            return snapShot[index].get(sidx);
//        }
//        }
//        
//        return 0;
//        
//    }
//}
