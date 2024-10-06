package com.rs.java.examples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOfConsonantsAndVowels {

	public static void main(String[] args) {
		String s = "count the consonants and vowels in this stirng";
		Map<Character, Integer> count = new HashMap<>();
		count.put('a', 0);
		count.put('e', 0);
		count.put('i', 0);
		count.put('o', 0);
		count.put('u', 0);
		count.put('c', 0);
		String[] arr = s.split("\\s+");

		Arrays.asList(arr).forEach(word -> {
			for (char c : word.toLowerCase().toCharArray()) {
				switch (c) {
				case 'a':
					count.put(c, count.get(c) + 1);
					break;
				case 'e':
					count.put(c, count.get(c) + 1);
					break;
				case 'i':
					count.put(c, count.get(c) + 1);
					break;
				case 'o':
					count.put(c, count.get(c) + 1);
					break;
				case 'u':
					count.put(c, count.get(c) + 1);
					break;
				default:
					count.put('c', count.get('c') + 1);
					break;
				}
			}
		});

		System.out.println("Word count in string: " + arr.length);
		System.out.println(count);
	}

}
