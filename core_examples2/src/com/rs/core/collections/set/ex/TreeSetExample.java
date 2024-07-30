package com.rs.core.collections.set.ex;

import java.util.Iterator;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// 1.
		Set<String> southStates = new TreeSet<String>();
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.add("AP");
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.add("TS");
		southStates.add("TN");
		southStates.add("AP");
		southStates.add("AP");
		southStates.add("KL");
		southStates.add("KA");
		// southStates.add(null);
		// 2.
		Set<String> northStates = new TreeSet<String>();
		northStates.add("JK");
		northStates.add("MP");
		northStates.add("UP");
		northStates.add("RJ");
		northStates.add("MH");
		northStates.add("HP");
		// 3.
		Set<String> indiaStates = new TreeSet<String>();
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
