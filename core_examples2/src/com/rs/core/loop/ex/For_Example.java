package com.rs.core.loop.ex;

public class For_Example {

	public static void main(String[] args) {
		System.out.println("start");
		int sum = 0;
		// for(initialization; condition; increment/decrement)
		for (int index = 1; index <= 10; index++) {
			if (index == 4) {
				continue;
			}
			if (index == 7) {
				break;
			}
			sum = sum + index;
		}
		System.out.println(sum);
		System.out.println("end");
	}

}
