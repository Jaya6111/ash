package com.rs.java.examples;

import java.util.List;
import java.util.stream.Collectors;

public class InterviewQ2 {

	public static void main(String[] args) {
		
		String input = "Kbzb!Tvszb";
		List<Character> nextAlphabets = input.chars().mapToObj(c -> (char) (c - 1)).collect(Collectors.toList());
		System.out.println(nextAlphabets);
		
		StringBuilder sb = new StringBuilder();
		for (char ch : nextAlphabets)
			sb.append(ch);

		System.out.println(sb.toString());
	}

}
