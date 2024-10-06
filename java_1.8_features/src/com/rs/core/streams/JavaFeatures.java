package com.rs.core.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaFeatures {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 7, 3, 9, 4, 5);
		//Set<Integer> set = new LinkedHashSet<Integer>(list);
		//list.sort(null);
		/*
		 * list.sort(null); System.out.println(list);
		 */

		Collections.sort(list);
		System.out.println(list);

		System.out.println(
				list.stream().allMatch(e -> e % 2 == 0) ? "All the numbers are even" : "All the numbers are not even");

		list.stream().map(a -> a + 1).filter(a -> a % 2 == 0).forEach(a -> System.out.print(a + " "));
		System.out.println();
		Map<String, Integer> map = new HashMap<>();
		map.put("Alice", 25);
		map.put("Bob", 30);
		map.put("Charlie", 35);

		Map<String, Integer> sortedMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
		System.out.println("map after sorting by values in descending order:\n" + sortedMap);

	}

}
