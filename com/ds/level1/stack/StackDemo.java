package com.ds.level1.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackDemo {

	/*
	 * 1. You are given a string exp representing an expression. 2. Assume that the
	 * expression is balanced i.e. the opening and closing brackets match with each
	 * other. 3. But, some of the pair of brackets maybe extra/needless. 4. You are
	 * required to print true if you detect extra brackets and false otherwise.
	 * 
	 * e.g.' ((a + b) + (c + d)) -> false (a + b) + ((c + d)) -> true
	 */
	public static void duplicateBrackets(String str) {

		Stack<Character> st = new Stack<>();
		for (char ch : str.toCharArray()) {

			if (ch == ')') {
				if (st.peek() == '(') {
					System.out.println(true);
					return;
				} else {
					while (st.size() > 0 && st.peek() != '(') {
						st.pop();
					}
					st.pop();
				}

			} else {
				st.push(ch); // opening bracket or some char
			}
		}

		System.out.println(false);
	}

	/*
	 * 1. You are given a string exp representing an expression. 2. You are required
	 * to check if the expression is balanced i.e. closing brackets and opening
	 * brackets match up well.
	 * 
	 * e.g. [(a + b) + {(c + d) * (e / f)}] -> true [(a + b) + {(c + d) * (e / f)]}
	 * -> false [(a + b) + {(c + d) * (e / f)} -> false ([(a + b) + {(c + d) * (e /
	 * f)}] -> false
	 */
	public static void balancedBracket(String str) {
		Stack<Character> st = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')') {
				if (st.size() == 0) {
					System.out.println(false);
					return;
				} else if (st.peek() != '(') {
					System.out.println(false);
					return;
				} else {
					st.pop();
				}

			} else if (ch == ']') {
				if (st.size() == 0) {
					System.out.println(false);
					return;
				} else if (st.peek() != '[') {
					System.out.println(false);
					return;
				} else {
					st.pop();
				}
			} else if (ch == '}') {
				if (st.size() == 0) {
					System.out.println(false);
					return;
				} else if (st.peek() != '{') {
					System.out.println(false);
					return;
				} else {
					st.pop();
				}

			}
		}

		if (st.size() > 0) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}
	}

	public static int[] nextGreaterOnRight(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[arr.length - 1] = -1;
		st.push(arr[arr.length - 1]);

		for (int i = arr.length - 2; i >= 0; i--) {

			int val = arr[i];

			while (st.size() > 0 && st.peek() <= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(val);

		}

		return ans;
	}

	// in this approach we will traverse from top to last.
	public static int[] nextGreaterOnRight2(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(0); // pushing the indexes.

		for (int i = 1; i < arr.length; i++) {

			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				int pidx = st.pop();
				ans[pidx] = arr[i];
			}

			st.push(i);

		}

		while (st.size() > 0) {
			int pidx = st.pop();
			ans[pidx] = -1;
		}

		return ans;
	}

	// it will give the index of next greater element on right.
	public static int[] nextGreaterIndexOnRight(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[arr.length - 1] = -1;
		st.push(arr.length - 1);

		for (int i = arr.length - 2; i >= 0; i--) {

			int val = arr[i];

			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;
	}

	public static int[] nextSmallestOnRight(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[arr.length - 1] = -1;
		st.push(arr[arr.length - 1]);

		for (int i = arr.length - 2; i >= 0; i--) {

			int val = arr[i];

			while (st.size() > 0 && st.peek() >= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(val);

		}

		return ans;
	}

	// it will give the index of next small element on right.
	public static int[] nextSmallestIndexOnRight(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[arr.length - 1] = -1;
		st.push(arr.length - 1);

		for (int i = arr.length - 2; i >= 0; i--) {

			int val = arr[i];

			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;
	}

	public static int[] nextGreaterOnLeft(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[0] = -1;
		st.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			int val = arr[i];

			while (st.size() > 0 && st.peek() <= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(val);

		}

		return ans;
	}

	// in this approach we will traverse from last to top.
	public static int[] nextGreaterOnLeft2(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);

		for (int i = arr.length - 2; i >= 0; i--) {

			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				int pidx = st.pop();
				ans[pidx] = arr[i];
			}

			st.push(i);

		}

		while (st.size() > 0) {
			int pidx = st.pop();
			ans[pidx] = -1;
		}

		return ans;
	}

	// it will give the index of next greater element on left.
	public static int[] nextGreaterIndexOnLeft(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[0] = -1;
		st.push(0);

		for (int i = 1; i < arr.length; i++) {

			int val = arr[i];

			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;
	}

	public static int[] nextSmallestOnLeft(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[0] = -1;
		st.push(arr[0]);

		for (int i = 1; i < arr.length; i++) {

			int val = arr[i];

			while (st.size() > 0 && st.peek() >= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(val);

		}

		return ans;
	}

	// it will give the index of next small element on left.
	public static int[] nextSmallestIndexOnLeft(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[0] = -1;
		st.push(0);

		for (int i = 1; i < arr.length; i++) {

			int val = arr[i];

			while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;
	}

	static class Pair {
		int val;
		int idx;

		Pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}

	}

	public static int[] StockSpan(int[] arr) {
		int[] ans = new int[arr.length];
		Stack<Pair> st = new Stack<>();

		ans[0] = 1;
		st.push(new Pair(arr[0], 0)); // pushing the index in stack

		for (int i = 1; i < arr.length; i++) {
			Pair p = new Pair(arr[i], i);

			while (st.size() > 0 && st.peek().val < p.val) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - st.peek().idx;
			}

			st.push(p);
		}

		return ans;
	}

	public static int[] stockSpan2(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int ans[] = new int[arr.length];

		ans[0] = 1; // for first element stock will be 1.
		st.push(0); // pushing the index in stack

		for (int i = 1; i < arr.length; i++) {

			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = i + 1;
			} else {
				ans[i] = i - st.peek();
			}

			st.push(i);

		}

		return ans;

	}

	// in this approach we are finding next greater to left(from last to top).
	public static int[] stockSpan3(int[] arr) {

		Stack<Integer> st = new Stack<>();
		int ans[] = new int[arr.length];

		st.push(ans.length - 1); // pushing the index in stack

		for (int i = ans.length - 2; i >= 0; i--) {

			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				int pidx = st.pop();
				ans[pidx] = pidx - i;
			}

			st.push(i);

		}

		while (st.size() > 0) {
			int pidx = st.pop();
			ans[pidx] = pidx + 1;
		}

		return ans;

	}

	public static void laregestAreaHistogram(int ar[]) {
		int left[] = getSmallestIndeOnLeft(ar);
		int right[] = getSmallestIndeOnRight(ar);

		int area[] = new int[ar.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ar.length; i++) {

			int width = right[i] - left[i] - 1;
			area[i] = width * ar[i];
			if (area[i] > max) {
				max = area[i];
			}

		}

		System.out.println(max);
	}

	// gives the next samller indexes on left.
	public static int[] getSmallestIndeOnLeft(int ar[]) {

		Stack<Integer> st = new Stack<>();
		int ans[] = new int[ar.length];

		ans[0] = -1;
		st.push(0);
		for (int i = 1; i < ar.length; i++) {

			while (st.size() > 0 && ar[st.peek()] >= ar[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = -1;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;

	}

	// gives the next smaller indexes on right.
	public static int[] getSmallestIndeOnRight(int ar[]) {

		Stack<Integer> st = new Stack<>();
		int ans[] = new int[ar.length];

		ans[ar.length - 1] = ar.length;
		st.push(ar.length - 1);
		for (int i = ar.length - 2; i >= 0; i--) {

			while (st.size() > 0 && ar[st.peek()] >= ar[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = ar.length;
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;

	}

	/*
	 * 1. You are given a number n, representing the size of array a. 2. You are
	 * given n numbers, representing the elements of array a. 3. You are given a
	 * number k, representing the size of window. 4. You are required to find and
	 * print the maximum element in every window of size k.
	 * 
	 * 
	 * This is most optimized approach in O(n) time.
	 */
	public static void slidingWindowMaximum(int ar[], int k) {
		int right[] = getGreaterIndexOnRight(ar);

		int j = 0;
		for (int i = 0; i <= ar.length - k; i++) {

			if (j < i) {
				j = i; // more optimized.
			}
			// int j = i;
			while (right[j] < i + k) {
				j = right[j];
			}

			System.out.println(ar[j]);

		}
	}

	// gives the next greater index on right.
	public static int[] getGreaterIndexOnRight(int[] arr) {

		int ans[] = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		ans[arr.length - 1] = arr.length;
		st.push(arr.length - 1);

		for (int i = arr.length - 2; i >= 0; i--) {

			int val = arr[i];

			while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
				st.pop();
			}

			if (st.size() == 0) {
				ans[i] = arr.length; // those who don't have next greater will assign array length.
			} else {
				ans[i] = st.peek();
			}

			st.push(i);

		}

		return ans;
	}

	// 2 + 6 * 4 / 8 - 3 => 2
	public static void infixEvaluation(String str) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				operators.push(ch);
			} else if (ch >= '0' && ch <= '9') {
				operands.push(ch - '0');
			} else if (ch == ')') {
				while (operators.peek() != '(') {
					char optor = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();

					int opv = operations(v1, v2, optor);
					operands.push(opv);
				}

				operators.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				// ch wanting higher priority to solve first.
				while (operators.size() > 0 && operators.peek() != '('
						&& precedency(ch) <= precedency(operators.peek())) {
					char optor = operators.pop();
					int v2 = operands.pop();
					int v1 = operands.pop();

					int opv = operations(v1, v2, optor);
					operands.push(opv);
				}

				operators.push(ch);
			}
		}

		while (operators.size() > 0) {
			char optor = operators.pop();
			int v2 = operands.pop();
			int v1 = operands.pop();

			int opv = operations(v1, v2, optor);
			operands.push(opv);
		}

		System.out.println(operands.peek());

	}

	/*
	 * 1. You are given an infix expression. 2. You are required to convert it to
	 * postfix and print it. 3. You are required to convert it to prefix and print
	 * it.
	 */
	public static void infixConversion(String exp) {
		Stack<Character> operator = new Stack<>();
		Stack<String> post = new Stack<>();
		Stack<String> pre = new Stack<>();

		for (char ch : exp.toCharArray()) {
			if (ch == '(') {
				operator.push(ch);
			} else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				post.push(ch + "");
				pre.push(ch + "");
			} else if (ch == ')') {
				while (operator.peek() != '(') {
					process(operator, post, pre);
				}
				operator.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (operator.size() > 0 && operator.peek() != '(' && precedency(ch) <= precedency(operator.peek())) {
					process(operator, post, pre);
				}
				operator.push(ch);
			}
		}

		while (operator.size() > 0) {
			process(operator, post, pre);
		}

		System.out.println(post.pop());
		System.out.println(pre.pop());
	}

	// we are repeating this task again and again that's why put this logic in
	// function.
	public static void process(Stack<Character> operator, Stack<String> post, Stack<String> pre) {
		char opr = operator.pop();
		String postV2 = post.pop();
		String postV1 = post.pop();
		String postV = postV1 + postV2 + opr;
		post.push(postV);

		String preV2 = pre.pop();
		String preV1 = pre.pop();
		String preV = opr + preV1 + preV2;
		pre.push(preV);
	}

	/*
	 * 1. You are given a postfix expression. 2. You are required to evaluate it and
	 * print it's value. 3. You are required to convert it to infix and print it. 4.
	 * You are required to convert it to prefix and print it.
	 * 
	 * Note -> Use brackets in infix expression for indicating precedence
	 */
	public static void postfixEvaluationAndConversion(String exp) {
		Stack<Integer> operand = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> prefix = new Stack<>();

		for (char ch : exp.toCharArray()) {
			if (ch >= '0' && ch <= '9') {
				operand.push(ch - '0');
				infix.push(ch + "");
				prefix.push(ch + "");
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

				int v2 = operand.pop();
				int v1 = operand.pop();
				int ans = operations(v1, v2, ch);
				operand.push(ans);

				String inV2 = infix.pop();
				String inV1 = infix.pop();
				String inV = "(" + inV1 + ch + inV2 + ")";
				infix.push(inV);

				String preV2 = prefix.pop();
				String preV1 = prefix.pop();
				String preV = ch + preV1 + preV2;
				prefix.push(preV);
			}
		}

		// code
		System.out.println(operand.pop());
		System.out.println(infix.pop());
		System.out.println(prefix.pop());
	}

	/*
	 * 1. You are given a prefix expression. 2. You are required to evaluate it and
	 * print it's value. 3. You are required to convert it to infix and print it. 4.
	 * You are required to convert it to postfix and print it.
	 * 
	 * Note -> Use brackets in infix expression for indicating precedence.
	 */

	// for prefix we will traverse from last.
	public static void prefixEvaluationAndConversion(String exp) {
		Stack<Integer> operand = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> postfix = new Stack<>();

		for (int i = exp.length() - 1; i >= 0; i--) {
			char ch = exp.charAt(i);
			if (ch >= '0' && ch <= '9') {
				operand.push(ch - '0');
				infix.push(ch + "");
				postfix.push(ch + "");
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

				int v1 = operand.pop();
				int v2 = operand.pop();
				int ans = operations(v1, v2, ch);
				operand.push(ans);

				String inV1 = infix.pop();
				String inV2 = infix.pop();
				String inV = "(" + inV1 + ch + inV2 + ")";
				infix.push(inV);

				String postV1 = postfix.pop();
				String postV2 = postfix.pop();
				String postV = postV1 + postV2 + ch;
				postfix.push(postV);
			}
		}

		// code
		System.out.println(operand.pop());
		System.out.println(infix.pop());
		System.out.println(postfix.pop());
	}

	public static int precedency(char ch) {
		if (ch == '+') {
			return 1;
		} else if (ch == '-') {
			return 1;
		} else if (ch == '*') {
			return 2;
		} else {
			return 2;
		}
	}

	public static int operations(int v1, int v2, char ch) {
		if (ch == '+') {
			return v1 + v2;
		} else if (ch == '-') {
			return v1 - v2;
		} else if (ch == '*') {
			return v1 * v2;
		} else {
			return v1 / v2;
		}
	}

	/*
	 * 1. You are given a pattern of upto 8 length containing characters 'i' and
	 * 'd'. 2. 'd' stands for decreasing and 'i' stands for increasing 3. You have
	 * to print the smallest number, using the digits 1 to 9 only without
	 * repetition, such that the digit decreases following a d and increases
	 * follwing an i.
	 * 
	 * e.g. d -> 21 i -> 12 ddd -> 4321 iii -> 1234 dddiddd -> 43218765 iiddd ->
	 * 126543
	 */
	public static void smallestNumberFollowingPattern(String str) {
		int val = 1;
		Stack<Integer> st = new Stack<>();
		for (char ch : str.toCharArray()) {
			if (ch == 'd') {
				st.push(val);
				val++;
			} else {
				st.push(val);
				val++;
				while (st.size() > 0) {
					System.out.print(st.pop());
				}
			}
		}

		st.push(val); // we push extra at the end
		while (st.size() > 0) {
			System.out.print(st.pop());
		}
	}

	/*
	 * 1. You are given a number n, representing the number of people in a party. 2.
	 * You are given n strings of n length containing 0's and 1's 3. If there is a
	 * '1' in ith row, jth spot, then person i knows about person j. 4. A celebrity
	 * is defined as somebody who knows no other person than himself but everybody
	 * else knows him. 5. If there is a celebrity print it's index otherwise print
	 * "none".
	 * 
	 * Note -> There can be only one celebrity
	 */
	public static void findCelebrity(int[][] ar) {
		// if a celebrity is there print it''s index (not position), if there is not
		// then
		// print "none"

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < ar.length; i++) {
			st.push(i);
		}

		while (st.size() >= 2) {
			int i = st.pop();
			int j = st.pop();

			if (ar[i][j] == 1) {
				st.push(j);
			} else {
				st.push(i);
			}
		}

		int pot = st.pop();
		for (int i = 0; i < ar.length; i++) {
			if (i != pot) {
				if (ar[i][pot] == 0 || ar[pot][i] == 1) {
					System.out.println("none");
					return;
				}
			}
		}

		System.out.println(pot);
	}

	public static void main(String[] args) {
		balancedBracket("([(a + b) + {(c + d) * (e / f)}]");
		int ar[] = { 5, 3, 8, 4, 7 };
		int ans[] = nextGreaterOnLeft2(ar);
		System.out.println(Arrays.toString(ans));
	}

}
