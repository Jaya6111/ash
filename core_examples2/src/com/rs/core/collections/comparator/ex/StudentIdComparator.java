package com.rs.core.collections.comparator.ex;

import java.util.Comparator;

public class StudentIdComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getId() > student2.getId()) {
			return 1;
		} else if (student1.getId() < student2.getId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
