package com.rs.core.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaFeatures {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.sort(null);
		Collections.sort(list);
		System.out.println(
				list.stream().allMatch(e -> e % 2 == 0) ? "All the numbers are even" : "All the numbers are not even");
	}
}
