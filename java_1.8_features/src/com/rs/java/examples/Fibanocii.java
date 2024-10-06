package com.rs.java.examples;

import java.util.stream.IntStream;

public class Fibanocii {

	public static void main(String[] args) {

		int n = 10;

		final long[] fibArray = { 0, 1 };

		IntStream.range(0, n).forEach(i -> {
			System.out.print(fibArray[0] + " ");

			long nextFib = fibArray[0] + fibArray[1];

			fibArray[0] = fibArray[1];
			fibArray[1] = nextFib;	
		});
	}

}
