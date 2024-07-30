package com.rs.core.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JavaFeatures2 {
	public static void main(String[] args) {

		List<String> names = Arrays.asList("apple", "mango", "grap", "papaya", "banana");

		Optional<String> word = names.stream().filter(e -> e.startsWith("b")).findFirst();
		System.out.println(word.get());
		//20,30,40,50,20,10,50
	}
}
