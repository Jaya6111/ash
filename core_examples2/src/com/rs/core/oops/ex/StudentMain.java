package com.rs.core.oops.ex;

public class StudentMain {

	public static void main(String[] args) {
		// 1.create object to the student class
		// classname objectname = new classname();
		Student student = new Student();

		// 2.set the 8 property data to the student object
		student.setId(577);
		student.setName("Anusha");
		student.setGender('f');
		student.setTeluguMarks(80);
		student.setHindiMarks(70);
		student.setMathsMarks(60);
		student.setScienceMarks(80);
		student.setSocialMarks(80);

		// 3.get the 8 property data from the student object

		int id = student.getId();
		String name = student.getName();
		char gender = student.getGender();
		int teluguMarks = student.getTeluguMarks();
		int hindiMarks = student.getHindiMarks();
		int mathsMarks = student.getMathsMarks();
		int scienceMarks = student.getScienceMarks();
		int socialMarks = student.getSocialMarks();
		// 4.to print the 8 property data in the console view
		System.out.println("Id :" + id);
		System.out.println("Name :" + name);
		System.out.println("Gender :" + gender);
		System.out.println("TeluguMarks :" + teluguMarks);
		System.out.println("HindiMarks :" + hindiMarks);
		System.out.println("MathsMarks :" + mathsMarks);
		System.out.println("ScienceMarks :" + scienceMarks);
		System.out.println("SocialMarks :" + socialMarks);
		// 5.create object to the StudentMain class
		// StudentMain studentMain = new StudentMain();
		// 6.get the language total marks to print it in the console view
		int languageMarks = StudentMain.getTotalMarks(teluguMarks, hindiMarks);
		System.out.println("languagemarks :" + languageMarks);
		// 7.get the non language total marks to print it in the console view
		int nonLanguageTotalMarks = StudentMain.getTotalMarks(mathsMarks, scienceMarks, socialMarks);
		System.out.println("nonLanguageMarks :" + nonLanguageTotalMarks);

	}

	public static int getTotalMarks(int teluguMarks, int hindiMarks) {
		return teluguMarks + hindiMarks;
	}

	public static int getTotalMarks(int mathsMarks, int scienceMarks, int socialMarks) {
		return mathsMarks + scienceMarks + socialMarks;

	}
}
