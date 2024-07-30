package com.rs.core.oops.inheritance.ex;

public class Daughter extends Father {

	public static void main(String[] args) {
		// 1.create object to the daughter class
		Father father = new Daughter();
		// get the amount to print it in the console view
		float amountToDaughter = father.getAmount(40);
		System.out.println(amountToDaughter);
	}

	@Override
	public float getAmount(int percentage) {
		return (super.credits - super.debits) * percentage / 100;
	}

}
