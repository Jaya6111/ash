package com.rs.core.examples;

//Java program to illustrate Constructor Chaining to
//other class using super() keyword
class Base {
	String name;

	// constructor 1
	Base() {
		this("");
		System.out.println("No-argument constructor of" + " base class");
	}

	// constructor 2
	Base(String name) {
		this.name = name;
		System.out.println("Calling parameterized constructor" + " of base class");
	}
}

public class Main extends Base {
	// constructor 3
	Main() {
		System.out.println("No-argument constructor " + "of derived");
	}

	// parameterized constructor 4
	Main(String name) {
		// invokes base class constructor 2
		super(name);
		System.out.println("Calling parameterized " + "constructor of derived");
	}

	public static void main(String args[]) {
		// calls parameterized constructor 4
		Main obj = new Main("test");

		// Calls No-argument constructor
		// Derived obj = new Derived();
	}
}
