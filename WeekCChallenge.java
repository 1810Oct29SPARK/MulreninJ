public class WeekCChallenge {

	public static void main(String[] args){
		
		//1. create a new instance of the Calculator class
		Calculator doThis = new Calculator();

		//2. call each of Calculator's instance methods: add, subtract, multiply, and divide
		// with arguments of your choice, assigning the result to the variables below
		
		double additionResult;
		double subtractionResult;
		double multiplicationResult;
		double divisionResult;
		additionResult = doThis.add(5.9,6.1);
		subtractionResult = doThis.subtract(8.1, 3.1);
		multiplicationResult = doThis.multiply(3.0, 4.0);
		divisionResult = doThis.divide(12.4, 3.1);

		

		//3. print the value of each of these variables to the console with a descriptive message
		System.out.println("The result of 5.9 + 6.1 = " + additionResult);
		System.out.println("The result of 8.1 - 3.1 = " + subtractionResult);
		System.out.println("The result of 3.0 * 4.0 = " + multiplicationResult);
		System.out.println("The result of 12.4 /3.1 = " + divisionResult);

		//4. implement the static fizzBuzz method in this class and call it from the main method
		int[] numberArray = {4,10};
		String[] termsArray = {"fizz","buzz"};
		fizzBuzz(1,100,numberArray, termsArray);
	}
	

	public static void fizzBuzz(int m, int n, int[] numbers, String[] terms){
		if(m > n || numbers.length != terms.length){
			System.out.println("Invalid Input, Try Again");
		}else{
			for(int i = m; i <= n; i++){
				int fizzBuzzNum = 0;
				String outputNum = "";
				for(int j = 0; j < numbers.length; j++){
					if(i % numbers[j] == 0){
						fizzBuzzNum = 1;
						outputNum += terms[j];
					}
				}
				if(fizzBuzzNum == 0){
					System.out.println(i);
				}else{
					System.out.println(outputNum);
				}
			}
		}
	}
}
