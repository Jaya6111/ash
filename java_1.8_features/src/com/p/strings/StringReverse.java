package com.p.strings;

public class StringReverse {
	public static void main(String[] args) {

		String s = "hello\nevery\n\none";
		String[] arr = s.split("\\n+");

		for (String e : arr) {
			StringBuffer sb = new StringBuffer(e);
			sb.reverse();
			System.out.print(sb + " ");
		}
	}
}
