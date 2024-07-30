package com.rs.optional;

import java.util.Optional;

public class OptionalTwo {

	public static void main(String[] args) {
		
		String s = "Hello";

		Optional<String> optional = Optional.ofNullable(s);
		String n = optional.orElse("nothing");
		System.out.println("String: " + n);

		String a = null;
		
		Optional<String> o = Optional.ofNullable(a);
		
		String b = o.orElse(s);
		System.out.println(b);
	}
}
