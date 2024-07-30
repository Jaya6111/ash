package com.rs.core.keyword.ex;

public class Return_Void_Example {

	public static void main(String[] args) {
		System.out.println("start");
		int marks = 570;
		int subjects = 6;
		float averagemarks = 0;

		averagemarks = getAverageMarks(marks, subjects);
		printAverageMarks(averagemarks);

		System.out.println("end");

	}

	public static float getAverageMarks(int marks, int subjects) {
		return marks / subjects;
	}

	public static void printAverageMarks(float averagemarks) {
		System.out.println(averagemarks);
	}
}
