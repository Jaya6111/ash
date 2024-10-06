package com.rs.java.examples;

import java.util.stream.IntStream;

public class Print100Nums {

	private static void print100Even() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

	private static void print100Odd() {
		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
	}

	public static void main(String[] args) {

		IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0) // Filter only even numbers
				.forEach(System.out::println); // Print each even number

		Print100Nums.print100Odd();

		System.out.println();

		Print100Nums.print100Even();
	}

}
