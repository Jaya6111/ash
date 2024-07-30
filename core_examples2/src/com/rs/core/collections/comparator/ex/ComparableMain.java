package com.rs.core.collections.comparator.ex;

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
		// 3.Iterate each element from the list object
		System.out.println(".......without sort......");
		Iterator<Student> iterator = students.iterator();
		Student student = null;
		while (iterator.hasNext()) {
			student = iterator.next();
			System.out.println(student.getId() + "," + student.getName() + "," + student.getMarks());

		}
		System.out.println(".......Id based sort......");
		Collections.sort(students, new StudentIdComparator());
		iterator = students.iterator();
		while (iterator.hasNext()) {
			student = iterator.next();
			System.out.println(student.getId() + "," + student.getName() + "," + student.getMarks());

		}
		System.out.println(".......Marks based sort......");
		Collections.sort(students, new StudentMarksComparator());
		iterator = students.iterator();
		while (iterator.hasNext()) {
			student = iterator.next();
			System.out.println(student.getId() + "," + student.getName() + "," + student.getMarks());

		}

	}
}
