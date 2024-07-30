package com.rs.core.comparable.ex;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ComparableMain {

	public static void main(String[] args) {
		// 1.Create the list object to hold student element reference
		List<Student> students = new ArrayList<>();

		// 2.add the 5 elements in to the list object
		students.add(new Student(3, "Anusha", 80));
		students.add(new Student(1, "Jaya", 70));
		students.add(new Student(4, "Gayatri", 50));
		students.add(new Student(5, "moni", 60));
		students.add(new Student(2, "Deepu", 30));
		// 3.sort the elements
		Collections.sort(students);
		// 4.Iterate each element from the list object
		Iterator<Student> iterator = students.iterator();
		Student student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			System.out.println(student.getId() + "," + student.getName() + "," + student.getMarks());
		}
	}

}
