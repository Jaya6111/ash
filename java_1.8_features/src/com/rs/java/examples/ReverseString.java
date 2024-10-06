package com.rs.java.examples;

import java.util.stream.IntStream;

public class ReverseString {
	public static void main(String[] args) {

		String s = "Hello World";
		StringBuffer reverseString = new StringBuffer();

		IntStream.range(0, s.length()).forEach(i -> {
			reverseString.append(s.charAt(s.length() - 1 - i));
		});
		System.out.println(reverseString.toString());
	}
}
