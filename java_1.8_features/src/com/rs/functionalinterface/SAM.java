package com.rs.functionalinterface;

public class SAM implements SAMInterface1 {

	@Override
	public void brouser() {
		System.out.println("It's a overriden method");
	}

	@Override
	public void wire() {
		SAMInterface1.super.wire();
	}

	private void socket() {
		System.out.println("It's a new method");
	}

	public static void main(String[] args) {
		SAM s = new SAM();
		s.socket();
	}
}
