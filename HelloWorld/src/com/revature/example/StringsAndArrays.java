package com.revature.example;

import java.util.Arrays;

public class StringsAndArrays {

	public static void main(String[] args) {
		funWithStrings();

	}

	static void funWithStrings() {
		//string literal
		String a = "hello";
		String b = new String("hello");
		
		/*
		 * .equals() is inherited from Object
		 * most reference types override to define "equality"
		 * (usually by the fields)
		 * String has it overridden to check the string literal
		 */
		System.out.println("string a is equal to string b: " + a.equals(b));
		
		/*
		 * == is good for comparing primitives
		 * or checking whether two objects are the same object
		 * (compares the REFERENCE)
		 */
		System.out.println("string a is the same object as string b: " + (a==b));
		
		//a and b are two different objects pointing to the same literal in the string pool
		
		/*
		 * String API methods
		 * substring
		 * concat
		 * toUpperCase
		 * toLowerCase
		 * replace
		 * indexOf
		 * split (provide the delimitor)
		 * getBytes
		 * trim
		 */
		
		 String test = "hello world";
		 System.out.println(test.toUpperCase());
		 String test2 = "HeLlO WorLd";
		 System.out.println(test2.toLowerCase());
		 System.out.println(test.substring(3,8));
		 System.out.println(test.concat(test2));
		 System.out.println(test.replace('l', 'p'));
		 System.out.println(test.indexOf('l'));
		 System.out.println(test.indexOf('L')); //no uppercase L
		 String test3 = "the quick brown fox jumped over the lazy dog";
		 String[] words = test3.split(" ");
		 for(String w : words) {
			 System.out.println(w);
		 }
	}
}
