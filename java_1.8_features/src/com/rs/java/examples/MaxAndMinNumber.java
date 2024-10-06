package com.rs.java.examples;

import java.util.stream.IntStream;

public class MaxAndMinNumber {
	public static void main(String[] args) {
		/*
		 * List<Integer> list = Arrays.asList(112, 43, 6, 7, 84, 33); int max =
		 * list.get(0), min = list.get(0); for (Integer num : list) { if (num > max) max
		 * = num; } for (Integer num : list) { if (num < min) min = num; }
		 */
		int max = IntStream.of(112, 43, 6, 7, 84, 33).max().getAsInt();
		
		int min = IntStream.of(112, 43, 6, 7, 84, 33).min().getAsInt();
		
		System.out.println("Max number: " + max);
		System.out.println("Min number: " + min);
	}
}
