package com.ds.level2.ArrayAndString;

//925. Long Pressed Name

/*
 * Your friend is typing his name into a keyboard. Sometimes, when typing a character c, the key might get
 *  long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible that it was your friends name, 
with some characters (possibly none) being long pressed.


 */

public class LongPressedName {

	public boolean isLongPressedName(String n, String t) {

		int i = 0;
		int j = 0;

		while (i < t.length()) {
			if (j < n.length() && t.charAt(i) == n.charAt(j)) {
				i++;
				j++;
			} else if (i > 0 && t.charAt(i) == t.charAt(i - 1)) {
				i++;
			} else {
				return false;
			}
		}

		return j == n.length();

	}

}
