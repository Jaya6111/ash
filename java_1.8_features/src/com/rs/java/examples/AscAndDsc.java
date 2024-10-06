package com.rs.java.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AscAndDsc {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		IntStream intStr = IntStream.of(11, 4, 1, 54, 6, 78, 5, 22).sorted();
		intStr.forEach(i -> System.out.print(i + " "));
		IntStream.of(11, 4, 1, 54, 6, 78, 5, 22).sorted().forEach(i -> {
			list.add(0, i);
		});

		System.out.println("\n-----------");
		System.out.println(list);

	}

}
