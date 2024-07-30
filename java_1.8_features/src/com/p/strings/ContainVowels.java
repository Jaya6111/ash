package com.p.strings;

public class ContainVowels {

	public static void main(String[] args) {
		String s = "Hello every one";
		System.out.println(s.toLowerCase().matches(".*[aeiou].*"));
	}
}
