package com.rs.core.examples;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RemoveOneDuplicateOccurrence {

	public static void main(String[] args) {
		String s2 = "This is is Sample String String Example Sample Example This is is Sample String String Example Sample Example";

		// Split the input string into words
		String[] words = s2.split(" ");

		// Create a map to store word occurrences
		Map<String, Integer> wordCount = new LinkedHashMap<>();

		// Create a list to store the result
		List<String> result = new ArrayList<>();

		// Process each word in the input string
		for (String word : words) {
			if (wordCount.containsKey(word)) {
				// If the word has occurred before, remove one occurrence
				if (wordCount.get(word) > 0) {
					result.add(word);
					wordCount.put(word, wordCount.get(word) - 1);
				}
			} else {
				// If it's the first occurrence of the word, add it to the result
				result.add(word);
				wordCount.put(word, 1);
			}
		}

		// Construct the final string from the result list
		String finalResult = String.join(" ", result);

		// Print the final result
		System.out.println("Original String:");
		System.out.println(s2);
		System.out.println("\nString with One Duplicate Occurrence Removed:");
		System.out.println(finalResult);
	}
}
