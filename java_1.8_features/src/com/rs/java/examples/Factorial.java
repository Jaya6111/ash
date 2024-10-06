package com.rs.java.examples;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Num: ");
		int num = s.nextInt();

		int total = 0;

		for (int i = 1; i <= num; i++) {
			if (i == 1)
				total = 1;
			total = total * i;
		}
		System.out.println(total);
	}

}
