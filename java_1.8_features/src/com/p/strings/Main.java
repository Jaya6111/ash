
package com.p.strings;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void main(String[] args) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
		System.out.println(LocalTime.now().format(formatter));
		System.out.println(LocalTime.now());
	}

	
}
