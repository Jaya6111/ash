package com.p.strings;

public class DuplicateWordsCount {

	public static void main(String[] args) {

		String s = "hello every one hello hi hi is is my hello hi hi is is my my one every";
		int count;
		String[] words = s.split(" ");
		for (int i = 0; i < words.length; i++) {
			count = 1;
			for (int j = i + 1; j < words.length; j++) {
				if (words[i].equalsIgnoreCase(words[j])) {
					count++;
					words[j] = "-1";
				}
			}
			if (count > 1 && words[i] != "-1")
				System.out.println(words[i] + " " + count);
		}
	}
}
