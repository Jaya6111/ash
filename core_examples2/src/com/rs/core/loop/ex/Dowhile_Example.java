package com.rs.core.loop.ex;

public class Dowhile_Example {

	public static void main(String[] args) {
		System.out.println("start");
		int sum = 0;
		int index = 1;

		do {
			sum = sum + index;
			index++;
		} while (index <= 5);
		System.out.println(sum);
		System.out.println("end");
	}

}
