package com.rs.core.loop.ex;

public class Switch_Example {

	public static void main(String[] args) {
		char grade = 'C';
		switch (grade) {
		case 'A':
			System.out.println("best");
			break;
		case 'B':
			System.out.println("better");
			break;
		case 'C':
			System.out.println("good");
			break;
		case 'D':
			System.out.println("bad");
			break;
		default:
			System.out.println("nothing to say");
		}

	}

}
