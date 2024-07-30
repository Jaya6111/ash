package com.iv.infosys1;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class InfosysInterviewQuestion {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(20, 30, 40, 50, 20, 10, 50);
		
		Collections.sort(list);
		Set<Integer> set = new LinkedHashSet<Integer>();

		list.forEach(n -> {
			if (set.contains(n)) {
				System.out.println(n);
			}
			set.add(n);
		});
	}

}