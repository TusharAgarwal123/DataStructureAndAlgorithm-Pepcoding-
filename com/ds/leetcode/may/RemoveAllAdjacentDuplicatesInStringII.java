package com.ds.leetcode.may;

import java.util.Stack;

// leetcode 1209. Remove All Adjacent Duplicates in String II
public class RemoveAllAdjacentDuplicatesInStringII {

	public String removeDuplicates(String s, int k) {

		Stack<Pair> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);

			if (st.size() > 0) {
				Pair peek = st.peek();

				if (ch != peek.ch) {
					Pair pp = new Pair(ch, 1);
					st.push(pp);
				} else {
					peek.fr++;
				}

				if (peek.fr % k == 0) {
					st.pop();
				}
			} else {
				Pair pp = new Pair(ch, 1);
				st.push(pp);
			}

		}

		// Stack<Pair> ss=new Stack<>();
		// while(st.size()!=0){
		// ss.push(st.pop());
		// }

		StringBuilder str = new StringBuilder();

		while (st.size() != 0) {
			Pair ppp = st.pop();
			for (int i = 0; i < ppp.fr; i++) {
				str.append(ppp.ch);
			}
		}

		return str.reverse().toString();
//	         while(ss.size()!=0){
//	             Pair ppp=ss.pop();
//	             for(int i=0;i<ppp.fr;i++){
//	                 str+=ppp.ch;
//	             }

//	         }

		// return str;

	}

	static class Pair {
		char ch;
		int fr;

		Pair(char ch, int fr) {
			this.ch = ch;
			this.fr = fr;
		}
	}
}
