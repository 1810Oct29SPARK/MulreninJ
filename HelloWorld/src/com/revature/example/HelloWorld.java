package com.revature.example;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		Calculator calc = new Calculator();
		
		System.out.println("The sum of 3.5 + 2.7 = " + calc.add(3.5,  2.7));
		String s = "5";
		Double d = Double.parseDouble(s);
		//check type of d, should be parsed as the WRAPPER CLASS Double,
		//not the primitive double (which is why .getClass() works)
		System.out.println(s.getClass());
		System.out.println(d.getClass());
		
		int[] nums = {4,5};
		String[] termsArray = {"fizz", "buzz"};
		fizzBuzz(1, 100, nums, termsArray);
	}

public static void fizzBuzz(int m, int n, int numbers[], String terms[]) {
	if(numbers.length != terms.length || m > n) {
		System.out.println("Invalid Input");
	}else {
		for(int i = m; i <= n; i++) {
			int count = 0;
			String eachTerm = "";
			for(int j = 0; j < numbers.length; j++) {
				if(i % numbers[j] == 0) {
					count = 1;
					eachTerm += terms[j];
				}
			}
			if(count == 0) {
				System.out.println(i);
			}else {
				System.out.println(eachTerm);
			}
		}
	}
}
}