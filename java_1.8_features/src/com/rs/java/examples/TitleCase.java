package com.rs.java.examples;

public class TitleCase {

	public static void main(String[] args) {

		String str = "this string is to convErt eAch word first leTter into Upper case";
		String[] arr = str.split("\\s+");
		String s = "";

		for (String word : arr) {
			String first = word.substring(0, 1).toUpperCase();
			String second = word.substring(1).toLowerCase();
			s += first + second + " ";
		}
		System.out.println(s);

	}
}
