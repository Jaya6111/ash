 package com.rs.core.collections.comparator.ex;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashCode_Equals_Examples {

	public static void main(String[] args) {
		// 1.Create the list object to hold student element reference
		Set<Student> students = new LinkedHashSet<>();

		// 2.add the 5 elements in to the list object
		students.add(new Student(3, "Anusha", 80));
		students.add(new Student(3, "Anusha", 80));
		students.add(new Student(3, "Anusha", 80));
		students.add(new Student(3, "Anusha", 80));
		students.add(new Student(4, "Anusha2", 70));
		students.add(new Student(4, "Anusha2", 70));
		students.add(new Student(4, "Anusha2", 70));
		students.add(new Student(4, "Anusha2", 70));
		students.add(new Student(3, "Anusha", 80));

		Iterator<Student> iterator = students.iterator();
		Student student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			System.out.println(student.getId() + "," + student.getName() + "," + student.getMarks());

		}

	}
}
