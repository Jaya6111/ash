package com.p.strings;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateWordsCount {

	public static void main(String[] args) {

		String s = "hello every one hello there hi hi is is my hello hi hi is is my my one every";

		Map<String, Long> wordCount = Arrays.stream(s.split("\\s+"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		wordCount.forEach((word, count) -> {
			if (count >= 1) {
				System.out.println(word + "-" + count);
			}
		});

		/*
		 * int count; String[] words = s.split(" "); for (int i = 0; i < words.length;
		 * i++) { count = 1; for (int j = i + 1; j < words.length; j++) { if
		 * (words[i].equalsIgnoreCase(words[j])) { count++; words[j] = "-1"; } } if
		 * (count > 1 && words[i] != "-1") System.out.println(words[i] + " " + count); }
		 */
	}
}
