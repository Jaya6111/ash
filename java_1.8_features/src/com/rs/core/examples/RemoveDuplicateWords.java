package com.rs.core.examples;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateWords {

	public static String removeDuplicates(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}

		String[] words = input.split("\\s+"); // Split by whitespace

		// LinkedHashSet named uniqueWords to store the unique words in the input
		// string. A LinkedHashSet preserves the order of insertion.
		Set<String> uniqueWords = new LinkedHashSet<>();

		for (String word : words) {
			uniqueWords.add(word);
		}

		return String.join(" ", uniqueWords);
	}

	public static void main(String[] args) {

		String s2 = "This is is Sample String String Example Sample Example This is is Sample String String Example Sample Example";

		String output = removeDuplicates(s2);
		System.out.println(output);

	}

}