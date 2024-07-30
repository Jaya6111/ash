package com.p.strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyOfRepeated {
	public static void main(String[] args) {

		String s = "jbaidv9gnefro897y34rnj97y3rb7gaefnhgxvlnqeoapabXc";
		char[] arr = s.toCharArray();
		Map<Character, Integer> lhm = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (lhm.containsKey(arr[i])) {
				int count = lhm.get(arr[i]) + 1;
				lhm.put(arr[i], count);
			} else {
				lhm.put(arr[i], 1);
			}
		}
		System.out.println(lhm);
	}
}
