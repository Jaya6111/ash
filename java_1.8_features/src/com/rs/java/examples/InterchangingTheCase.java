package com.rs.java.examples;

import java.util.stream.IntStream;

public class InterchangingTheCase {

	public static void main(String[] args) {

		String s = "jkJHsJIBvf";
		StringBuilder str = new StringBuilder(s);

		IntStream.range(0, str.length()).forEach(i -> {
			if (Character.isUpperCase(str.charAt(i)))
				str.setCharAt(i, Character.toUpperCase(str.charAt(i)));
			else
				str.setCharAt(i, Character.toLowerCase(str.charAt(i)));
		});

		System.out.println(str.toString());
	}
}
