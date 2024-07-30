package com.rs.pe;

import java.util.Scanner;

public class FibonacciNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Provide a Number: ");
		int n = sc.nextInt();
		int a = 0, b = 1, c = 0;
		for (int i = 0; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		System.out.println("Nth Fenonacci numbr is: \n" + c);
	}
}
