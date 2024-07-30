package com.rs.core.examples;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountOfDuplicates {

	public static void main(String[] args) {
		String s2 = "This is is Sample String String Example Sample Example This is is Sample String String Example Sample Example";

		// Split the input string into words
		String[] words = s2.split(" ");

		// Create a map to store word occurrences
		Map<String, Integer> wordCount = new LinkedHashMap<>();

		// Count word occurrences
		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		// Print the word and count of duplicates
		for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
			if (entry.getValue() > 0) {
				System.out.println("Word: " + entry.getKey() + ", Count: " + entry.getValue());
			}
		}
	}

}
