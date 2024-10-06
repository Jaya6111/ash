package com.rs.core.examples;

import java.util.Arrays;
import java.util.HashMap;

import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateWords {
	public static void main(String[] args) {
		String s = "This is is Sample String String        Example Sample Example This is is Sample String String Example Sample Example";

		String[] words = s.split("\\s+");

		Set<String> unique = new LinkedHashSet<String>();

		/*
		 * for (String word : words) { unique.add(word); }
		 */
		
		Arrays.asList(words).forEach(word -> unique.add(word));
		
		String uniqueString = String.join(" ", unique);
		System.out.println("The string without duplicates is: \n" + uniqueString);

		String input = "Hello, World! String removing   after  removing one of  occurrence of duplicates: ";
		String result = removeOneDuplicateOccurrence(input);
		System.out.println("Original String: " + input);
		System.out.println("String after removing one occurrence of duplicates: " + result);

	}

	private static String removeOneDuplicateOccurrence(String input) {
		StringBuilder result = new StringBuilder();
		HashMap<String, Integer> stringCount = new HashMap<>();
		String[] words = input.split("\\s+");

		for (String s : words) {
			// Increment the count of the character in the map
			stringCount.put(s, stringCount.getOrDefault(s, 0) + 1);

			// Add the character to the result if its count is less than or equal to 1
			if (stringCount.get(s) <= 1) {
				result.append(" " + s);
			}
		}
		return result.toString();
	}

}
