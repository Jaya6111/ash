package com.rs.core.collections.comparator.ex;

public class Student {
	private int id;
	private String name;
	private int marks;

	// Default constructor
	Student() {

	}

	// parameterized constructor
	Student(int id, String name, int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	
	

}
