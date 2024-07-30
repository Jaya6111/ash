package com.rs.core.exception.ex;

public class Try_Catch_Finally_Example {

	public static void main(String[] args) {
		System.out.println("start");

		int marks = 540;
		int subjects = 0;

		float averagemarks = 0;
		boolean isExceptionPresent = false;
		try {
			averagemarks = marks / subjects;
		} catch (ArithmeticException ae) {
			isExceptionPresent = true;
		} finally {
			System.out.println("please wait while fetching the data...");
		}
		if (isExceptionPresent) {
			System.out.println("server had failure.please try again later..");
		} else {
			System.out.println(averagemarks);

		}

		System.out.println("end");
	}

}
