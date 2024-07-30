package com.rs.core.conditional.ex;

public class If_Elseif_Else_Example {

	public static void main(String[] args) {
		System.out.println("start");
		int marks = 570;
		String grade = null;
		if (marks > 580) {
			grade = "A+";
		} else if (marks > 550) {
			grade = "A";
		} else if (marks > 530) {
			grade = "B+";
		} else if (marks > 480) {
			grade = "B";
		} else if (marks > 430) {
			grade = "C+";
		} else if (marks > 380) {
			grade = "C";
		} else {
			System.out.println("no grade");
		}
		System.out.println(grade);

		System.out.println("end");
	}
}
