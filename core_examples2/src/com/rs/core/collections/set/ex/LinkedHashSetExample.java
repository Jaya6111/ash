package com.rs.core.collections.set.ex;

import java.util.Iterator;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {

	public static void main(String[] args) {
		// 1.
		Set<String> southStates = new LinkedHashSet<String>();
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.add("AP");
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.add("TS");
		southStates.add("TN");
		southStates.add("AP");
		southStates.add("AP");
		southStates.add("KL");
		southStates.add("KA");
		southStates.add(null);
		// 2.
		Set<String> northStates = new LinkedHashSet<String>();
		northStates.add("JK");
		northStates.add("MP");
		northStates.add("UP");
		northStates.add("RJ");
		northStates.add("MH");
		northStates.add("HP");
		// 3.
		Set<String> indiaStates = new LinkedHashSet<String>();
		indiaStates.addAll(northStates);
		indiaStates.addAll(southStates);
		// 4.
		Iterator<String> iterator = indiaStates.iterator();
		String stateCode = null;
		while (iterator.hasNext()) {
			stateCode = iterator.next();
			System.out.println(stateCode);
		}
		System.out.println(indiaStates);

		System.out.println("After removing");
		indiaStates.remove("MH");
		System.out.println(indiaStates);

		System.out.println("After RemovingAll");
		indiaStates.removeAll(southStates);
		System.out.println(indiaStates);

		boolean contains = indiaStates.contains("AP");
		System.out.println("Contains :" + contains);

	}

}
