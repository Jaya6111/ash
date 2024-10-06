package com.rs.core.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Mapping digits to their corresponding strings
		Map<Integer, String> digitToString = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			int digit = scanner.nextInt();
			String associatedString = scanner.next();
			digitToString.put(digit, associatedString);
		}

		// The number for which we need to generate combinations
		String number = scanner.next();
		scanner.close();

		// List of strings corresponding to the digits in the number
		List<String> strings = new ArrayList<>();
		for (char digitChar : number.toCharArray()) {
			int digit = Character.getNumericValue(digitChar);
			if (digitToString.containsKey(digit)) {
				strings.add(digitToString.get(digit));
			}
		}

		// Generate all combinations
		List<String> combinations = new ArrayList<>();
		generateCombinations(strings, 0, "", combinations);

		// Sort combinations in ascending order
		Collections.sort(combinations);

		// Print all combinations separated by a space
		System.out.println(String.join(" ", combinations));
	}

	private static void generateCombinations(List<String> strings, int index, String current,
			List<String> combinations) {
		if (index == strings.size()) {
			combinations.add(current);
			return;
		}
		String currentString = strings.get(index);
		for (char c : currentString.toCharArray()) {
			generateCombinations(strings, index + 1, current + c, combinations);

		}

	}
}
