package com.rs.pe;

public class StringReverse {

	public static String rev(String s) {
		String reverse = "";
		char[] arr = s.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--) {
			reverse = reverse + arr[i];
		}
		return reverse;
	}

	public static String rs(String s) {
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse = reverse + s.charAt(i);
		}
		return reverse;
	}

	public static void main(String[] args) {
		String s = "reversing_a_string";
		StringBuffer rev = new StringBuffer(s);

		System.out.println(StringReverse.rev(s) + "\n" + rs(s));

		System.out.println(rev.reverse());
	}

}
