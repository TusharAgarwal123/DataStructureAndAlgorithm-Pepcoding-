package com.ds.leetcode.may;

import java.util.Stack;

/*
 * Given two strings s and t, return true if they are equal
 *  when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.
 */
//844. Backspace String Compare
public class BackspaceStringCompare {

	public boolean backspaceCompare(String s, String t) {

		Stack<Character> s1 = new Stack<>();
		Stack<Character> s2 = new Stack<>();

		for (Character ch : s.toCharArray()) {
			if (ch != '#') {
				s1.push(ch);
			} else {
				if (s1.size() > 0) {
					s1.pop();
				}
			}
		}

		for (Character ch : t.toCharArray()) {
			if (ch != '#') {
				s2.push(ch);
			} else {
				if (s2.size() > 0) {
					s2.pop();
				}
			}
		}

		// here we are generating the string from stacks and comparing the strings.
//	         StringBuilder ss1=new StringBuilder();
//	         for(Character ch:s1){
//	             ss1.append(ch);
//	         }

//	         StringBuilder ss2=new StringBuilder();
//	         for(Character ch:s2){
//	             ss2.append(ch);
//	         }

//	         return ss1.toString().equals(ss2.toString());

		while (s1.size() > 0) {

			char ch = s1.pop();
			if (s2.size() == 0 || s2.pop() != ch) {
				return false;
			}

		}

		return s1.isEmpty() && s2.isEmpty();

	}

}
