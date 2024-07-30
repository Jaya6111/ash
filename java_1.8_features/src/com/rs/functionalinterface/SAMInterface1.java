package com.rs.functionalinterface;

@FunctionalInterface
public interface SAMInterface1 {
	public void brouser();

	public static void socket() {
		int a = 1, b = 2;
		int c = a * b;
		System.out.println(c);
	}

	public static void socket2() {
		int a = 1, b = 2;
		int c = a * b;
		System.out.println(c);
	}

	default void wire() {
		System.out.println("It's a default method");
	}

	default void wire2() {
		System.out.println("It's a default method");
	}

}
