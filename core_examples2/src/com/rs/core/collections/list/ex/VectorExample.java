package com.rs.core.collections.list.ex;

import java.util.Enumeration;

import java.util.List;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		// 1.
		List<String> southStates = new Vector<String>();
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.add("AP");
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.add("TS");
		southStates.add("TN");
		southStates.add(1, "KL");
		southStates.add("KA");
		// 2.
		List<String> northStates = new Vector<String>();
		northStates.add("JK");
		northStates.add("MP");
		northStates.add("UP");
		northStates.add(0, "RJ");
		northStates.add("MH");
		northStates.add("HP");
		// 3.
		Vector<String> indiaStates = new Vector<String>();
		indiaStates.addAll(northStates);
		indiaStates.addAll(0, southStates);
		// 4.
		Enumeration<String> enumeration = indiaStates.elements();
		String stateCode = null;
		while (enumeration.hasMoreElements()) {
			stateCode = enumeration.nextElement();
			System.out.println(stateCode);
		}
		System.out.println(indiaStates);
		indiaStates.set(2, "TG");
		System.out.println("After Editing");
		System.out.println(indiaStates);

		System.out.println("After removing");
		indiaStates.remove("MH");
		System.out.println(indiaStates);

		System.out.println("After RemovingAll");
		indiaStates.removeAll(southStates);
		System.out.println(indiaStates);

		boolean contains = indiaStates.contains("AP");
		System.out.println("Contains :" + contains);

		int indexOf = indiaStates.indexOf("ap");
		System.out.println("indexOf :" + indexOf);

		int lastIndexOf = indiaStates.lastIndexOf("HP");
		System.out.println("lastIndexOf :" + lastIndexOf);
	}

}
