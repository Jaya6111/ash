package com.rs.core.accessspecifier.defaultex;

import com.rs.core.accessspecifier.protectedex.Father;

public class Son extends Father {
	static int sonCredits = 3000;

	public static void main(String[] args) {
		System.out.println(Son.sonCredits);
		System.out.println(Father.fatherCredits);
	}

}
