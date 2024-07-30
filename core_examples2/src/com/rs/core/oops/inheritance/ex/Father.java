package com.rs.core.oops.inheritance.ex;

public abstract class Father extends GrandFather {
	final int credits = 1000000;
	int debits = 300000;

	public abstract float getAmount(int percentage);

	public final float toWife() {
		return 500000;
	}

}
