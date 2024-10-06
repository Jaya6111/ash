package com.rs.java.examples;

import java.util.Arrays;
import java.util.List;

public class OddAndEvenNumbers {

	private static void oddNumbers(List<Integer> list) {

		list.forEach(element -> {
			if ((element % 2) != 0)
				System.out.print(element + " ");
		});
		System.out.println();
	}

	private static void evenNubers(List<Integer> list) {

		list.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.print(num + " "));
		System.out.println();
		System.out.println(list.stream().filter(num -> num % 2 == 0).reduce((a, b) -> b));
		System.out.println(list.stream().filter(num -> num % 2 == 0).findFirst());
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 22, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

		OddAndEvenNumbers.oddNumbers(list);
		OddAndEvenNumbers.evenNubers(list);
	}
}
