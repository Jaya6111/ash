package com.rs.core.collections.map.ex;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapExample {

	public static void main(String[] args) {
		// 1.
		Map<String, String> southStates = new TreeMap<>();
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.put("AP", "Andhra");
		System.out.println(southStates.size() + "," + southStates.isEmpty());
		southStates.put("TS", "Telangana");
		southStates.put("TN", "Tamil Nadu");
		southStates.put("AP", "Andhra Pradesh");
		southStates.put("KL", "Kerala");
		southStates.put("KA", "Karnataka");
		southStates.put("", null);
		// 2.
		Map<String, String> northStates = new TreeMap<>();
		northStates.put("JK", "Jammu&Kashmir");
		northStates.put("MP", "Madhya Pradesh");
		northStates.put("UP", "Uttar Pradesh");
		northStates.put("RJ", "Rajasthan");
		northStates.put("MH", "Maharastra");
		northStates.put("HP", "Himachal Pradesh");
		// 3.
		Map<String, String> indiaStates = new TreeMap<>();
		indiaStates.putAll(northStates);
		indiaStates.putAll(southStates);
		// 4.
		Set<String> keys = indiaStates.keySet();
		Iterator<String> iterator = keys.iterator();
		String key = null;
		String value = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			value = indiaStates.get(key);
			System.out.println(key + ":" + value);
		}
		System.out.println(indiaStates);

		System.out.println("After removing");
		indiaStates.remove("MH", "Maharastra");
		System.out.println(indiaStates);

		boolean containsKey = indiaStates.containsKey("AP");
		System.out.println("ContainsKey :" + containsKey);

		boolean containsValue = indiaStates.containsValue("Andhra Pradesh");
		System.out.println("ContainsValue :" + containsValue);

	}

}
