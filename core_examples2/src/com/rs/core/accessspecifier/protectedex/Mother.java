package com.rs.core.accessspecifier.protectedex;

import com.rs.core.accessspecifier.publicex.GrandFather;

public class Mother {
	protected static int motherCredits = 6000;

	public static void main(String[] args) {
		// System.out.println(Son.);
		System.out.println(GrandFather.grandFatherCredits);
		System.out.println(Father.fatherCredits);
	}

}
