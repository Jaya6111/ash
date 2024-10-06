package com.rs.java.examples;

public class ReverseTheNumber {
	public static void main(String[] args) {

		int num = 9868575;

		int reverseNum = Integer.parseInt(
				new StringBuilder(String.valueOf(num))
				.reverse().toString());
		System.out.println(reverseNum);
	}
}
