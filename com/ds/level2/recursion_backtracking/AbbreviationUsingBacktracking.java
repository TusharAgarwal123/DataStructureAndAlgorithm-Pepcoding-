package com.ds.level2.recursion_backtracking;

import java.util.Scanner;

/*
 * 1. You are given a word.
2. You have to generate all abbrevations of that word.
 */
public class AbbreviationUsingBacktracking {

	// on level we have characters and each character have 2 choice to come or not
	// come.
	public static void solution(String str, String asf, int count, int pos) {
		// write your code here

		if (pos == str.length()) {
			if (count == 0) {
				System.out.println(asf);
			} else {
				System.out.println(asf + count);
			}
			return;
		}

		// if(count>0){
		// solution(str,asf+count+str.charAt(pos),0,pos+1);
		// }else{
		// solution(str,asf+str.charAt(pos),0,pos+1);
		// }

		solution(str, asf + (count > 0 ? count : "") + str.charAt(pos), 0, pos + 1);
		solution(str, asf, count + 1, pos + 1);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "", 0, 0);
	}

}
