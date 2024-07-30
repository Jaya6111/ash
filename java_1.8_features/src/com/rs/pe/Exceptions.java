package com.rs.pe;

public class Exceptions {

	public static void main(String[] args) {

		try {
			System.out.println("first");
			int b =1/0;

			try {

				System.out.println("second");
				
				String a = new String();
				
				System.out.println("Null" + a.charAt(2));
				

			} catch (Exception e) {
				System.out.println("child catch");
			}
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(ex + "NullPointerException");
		} catch (ArithmeticException e) {
			System.out.println(e + "parent catch");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
