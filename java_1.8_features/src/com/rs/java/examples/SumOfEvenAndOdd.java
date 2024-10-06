package com.rs.java.examples;

import java.util.stream.IntStream;

public class SumOfEvenAndOdd {
	public static void main(String[] args) {
		int sum = IntStream.rangeClosed(1, 100).filter(num -> num % 2 == 0).sum();
		System.out.println("Sum of even Numbers: " + sum + "\n==========");
		
		int total = IntStream.range(1, 100).filter(num -> num % 2 != 0).sum();
		System.out.println("Sum of Odd Numbers: " + total);
		
	}
}
