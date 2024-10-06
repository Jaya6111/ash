package com.rs.java.examples;

public class PrimeNumber {

	public static boolean checkPrime(int num) {

		boolean isPrime = false;
		if (num == 2 || num == 3)
			return true;

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				isPrime = true;
				break;
			}
		}
		return isPrime;
	}

	public static void main(String[] args) {

		boolean isPrime = PrimeNumber.checkPrime(13);

		if (isPrime) {
			System.out.println("prime number");
		} else {
			System.out.println("not a prime number");
		}
	}

}
