package com.rs.core.loop.ex;

public class While_Example {

	public static void main(String[] args) {
		System.out.println("start");
		int sum = 0;
		// initialization is outside the while loop
		int index = 1;
		while (index <= 5)// condition is as a part of while declaration
		{
			sum = sum + index;
			// increment/decrement is within the while loop
			index++;
		}
		System.out.println(sum);
		System.out.println("end");
	}

}
