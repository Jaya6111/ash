package com.rs.core.loop.ex;

public class For_Example_Backward {

	public static void main(String[] args) {
		System.out.println("start");
		int sum = 0;
		// for(initialization; condition; increment/decrement)
		for (int index = 5; index >= 1; index--) {
			sum = sum + index;
		}
		System.out.println(sum);
		System.out.println("end");
	}

}
