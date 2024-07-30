package com.rs.core.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorExample {

	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Alice", 25));
		people.add(new Person("Bob", 30));
		people.add(new Person("Charlie", 20));

		// Using a Comparator to sort by age in ascending order
		people.sort(Comparator.comparingInt(Person::getAge));
		

		// Print the sorted list
		for (Person person : people) {
			System.out.println(person);
		}
	}

}
