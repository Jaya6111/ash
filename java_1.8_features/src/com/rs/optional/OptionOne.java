package com.rs.optional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionOne {

	public static void main(String[] args) {
		List<String> l = new LinkedList<String>();
		l.add("1");
		l.add("3");
		l.add(null);
		l.add("5");
		l.add("6");
		Optional<List<String>> o = Optional.ofNullable(l);
		o.ifPresent(li -> System.out.println(li.get(2)));

	}
}
