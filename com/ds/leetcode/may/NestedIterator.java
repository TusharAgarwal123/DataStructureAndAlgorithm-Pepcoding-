package com.ds.leetcode.may;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//leetcode 341. Flatten Nested List Iterator
public class NestedIterator { // implements Iterator<Integer> {

//	private List<Integer> list;
//	private int i = 0;
//
//	public NestedIterator(List<NestedInteger> nestedList) {
//
//		this.list = new ArrayList<>();
//		helper(nestedList);
//
//	}
//
//	public void helper(List<NestedInteger> nestedList) {
//
//		for (int i = 0; i < nestedList.size(); i++) {
//			if (nestedList.get(i).isInteger()) {
//				this.list.add(nestedList.get(i).getInteger());
//			} else {
//				helper(nestedList.get(i).getList());
//			}
//		}
//
//	}
//
//	@Override
//	public Integer next() {
//
////		int ans = -1;
////
////		if (i < this.list.size()) {
////			ans = this.list.get(i);
////			i++;
////		}
////
////		return ans;
//
//	}
//
//	@Override
//	public boolean hasNext() {
//
//		//return i < this.list.size();
//
//	}
}
