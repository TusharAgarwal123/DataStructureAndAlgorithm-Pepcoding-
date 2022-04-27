package com.ds.level2.hashmap;

import java.util.HashMap;
import java.util.Random;

/*
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it
 *  returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need
 to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

Implement the Solution class:

Solution() Initializes the object of the system.
String encode(String longUrl) Returns a tiny URL for the given longUrl.
String decode(String shortUrl) Returns the original long URL for the given shortUrl.
 It is guaranteed that the given shortUrl was encoded by the same object.
 */

//leetcode 535. Encode and Decode TinyURL.
public class EncodeAndDecodeTinyURL {

	HashMap<String, String> map = new HashMap<>();

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {

		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		char ch = (char) r.nextInt(100);

		sb.append(ch);

		while (map.containsKey(sb.toString()) == true) {
			ch = (char) r.nextInt(100);
			sb.append(ch);
		}

		map.put(sb.toString(), longUrl);

		return sb.toString();

	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return map.get(shortUrl);
	}

}
