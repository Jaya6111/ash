package com.rs.java.examples;

import java.util.stream.IntStream;

public class Palindrome {
	private static String isPalindrome(String s) {

		boolean isPalindrome = IntStream.range(0, s.length() / 2)
				.allMatch(i -> s.charAt(i) == s.charAt(s.length() - 1 - i));

		return isPalindrome ? "Palindrome" : "Not a palindrome";

	}

	public static void main(String[] args) {
		String s = "as11Sa";
		s = s.toLowerCase();
		String result = "Palindrome";

		int i = 0;
		for (char c : s.toCharArray()) {
			if (c == s.charAt(s.length() - 1 - i)) {
				i++;
				continue;
			} else {
				result = "Not a palindrome";
				break;
			}
		}
		System.out.println(result);
		System.out.println(Palindrome.isPalindrome(s));
	}
}
