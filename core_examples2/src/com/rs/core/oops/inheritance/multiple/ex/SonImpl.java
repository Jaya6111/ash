package com.rs.core.oops.inheritance.multiple.ex;

public class SonImpl implements Father, Mother {

	public static void main(String[] args) {
		// 1.get the amountFromFather and print it in the console view
		Father father = new SonImpl();
		float amountFromFather = father.getAmountFromFather(60);
		System.out.println("amountFromFather :" + amountFromFather);
		// 2.get the amountFromMother and print it in the console view
		Mother mother = new SonImpl();
		float amountFromMother = mother.getAmountFromMother(60);
		System.out.println("amountFromMother :" + amountFromMother);
	}

	@Override
	public float getAmountFromFather(int percentage) {
		return (Father.credits - Father.debits) * percentage / 100;
	}

	@Override
	public float getAmountFromMother(int percentage) {
		return (Mother.credits - Mother.debits) * percentage / 100;
	}

}
 