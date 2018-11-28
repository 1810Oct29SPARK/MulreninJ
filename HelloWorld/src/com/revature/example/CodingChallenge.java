package com.revature.example;

public class CodingChallenge {

	public static void main(String[] args) {
			System.out.println(reverse("reverse this word"));
			System.out.println(reverse("thisworks"));
	}
	
	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 *
	 * @param string
	 * @return
	 */
	public static String reverse(String string) {
		String reversal = "";
		for(int i = (string.length() - 1); i >= 0; i--) {
			reversal += string.charAt(i);
		}
		return reversal;
	}
}
