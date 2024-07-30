package com.rs.core.oops.inheritance.ex;

public class Son extends Father {

	public static void main(String[] args) {
		// 1.create object to the son class
		Father father = new Son();
		// get the amount to print it in the console view
		float amountToSon = father.getAmount(60);
		System.out.println(amountToSon);
	}

	@Override
	public float getAmount(int percentage) {
		// super.credits = 1400000;
		return (super.credits - super.debits) * percentage / 100;
	}
	/*
	 * @Override public float toWife() { // TODO Auto-generated method stub return
	 * super.towife(); }
	 */

}
