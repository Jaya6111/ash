package com.rs.java.examples;

public class ArmstrongNumver {
	public static void main(String[] args) {

		int num = 153, total = 0, i = 0;
		String s = String.valueOf(num);

		for (char c : s.toCharArray()) {
			i = Character.getNumericValue(c);
			total = total + (i * i * i);
		}

		System.out.println((total == num) ? "Armstrong Numver" : "Not a Armstrong Numver");
	}
}
