package com.rs.java.examples;

import java.util.HashMap;
import java.util.Map;

public class CountOfEachCharacter {

	int dCount = 0;
	int lCount = 0;
	int uCount = 0;
	int sCount = 0;

	public Map<Character, Integer> count(String s) {

		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			if (countMap.containsKey(c))
				countMap.put(c, countMap.get(c) + 1);
			else
				countMap.put(c, 1);

			if (Character.isLowerCase(c))
				lCount++;
			else if (Character.isUpperCase(c))
				uCount++;
			else if (Character.isDigit(c))
				dCount++;
			else
				sCount++;
		}

		System.out.println("Lower case count: " + lCount + "\nUpper case count: " + uCount + "\nDigits count: " + dCount
				+ "\nSpecial Charecters count: " + sCount);
		return countMap;
	}

	public static void main(String[] args) {

		String s = "This string is for counting characters";
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : s.toLowerCase().toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				if (c != ' ')
					map.put(c, 1);
			}
		}
		System.out.println(map);

		CountOfEachCharacter obj = new CountOfEachCharacter();
		obj.count(s);
	}

}
