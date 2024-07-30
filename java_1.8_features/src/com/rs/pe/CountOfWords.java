package com.rs.pe;

import java.util.HashMap;

public class CountOfWords {

	public static HashMap<Integer, String> count(String s) {
		String[] arr = s.split("\\s+");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		int i;
		for (i = 1; i <= arr.length; i++) {

			if (hm.containsKey(i)) {
				hm.put(i, arr[i-1]);
			} else
				hm.put(i, arr[i-1]);
		}
		System.out.println("Count : " + (i-1));
		return hm;
	}

	public static void main(String[] args) {
		String s = "This is to   count  number    of	 words";
		System.out.println(count(s));

	}

}
