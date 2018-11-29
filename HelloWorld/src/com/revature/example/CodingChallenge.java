package com.revature.example;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CodingChallenge {

	public static void main(String[] args) {
			System.out.println(reverse("reverse this word"));
			System.out.println(reverse("thisworks"));
			System.out.println(acronym("Portable Network Graphics"));
			System.out.println(acronym("First in, First out"));
			System.out.println(acronym("GNU Image Manipulation Program"));
			System.out.println(acronym("Complementary metal-oxide semiconductor"));
			Triangle triangle = new Triangle(5, 4, 6);
			System.out.println(triangle.isEquilateral());
			Triangle triangle1 = new Triangle(5, 5, 4);
			System.out.println(triangle1.isEquilateral());
			Triangle triangle2 = new Triangle(5, 5, 5);
			System.out.println(triangle2.isEquilateral());
			Triangle triangle3 = new Triangle(5, 5, 6);
			System.out.println(triangle3.isIsosceles());
			Triangle triangle4 = new Triangle(5, 4, 6);
			System.out.println(triangle4.isIsosceles());
			Triangle triangle5 = new Triangle(5, 5, 5);
			System.out.println(triangle5.isIsosceles());
			Triangle triangle6 = new Triangle(5, 5, 6);
			System.out.println(triangle6.isScalene());
			Triangle triangle7 = new Triangle(5, 4, 6);
			System.out.println(triangle7.isScalene());
			Triangle triangle8 = new Triangle(5, 5, 5);
			System.out.println(triangle8.isScalene());
			System.out.println(getScrabbleScore("cabbage"));
			System.out.println(getScrabbleScore("f"));
			System.out.println(getScrabbleScore("zoo"));
			System.out.println(getScrabbleScore("OxyphenButazone"));
			System.out.println(wordCount("one fish two fish"));
			System.out.println(isArmstrongNumber(9474));
			System.out.println(calculatePrimeFactorsOf(901255));
			System.out.println(calculateNthPrime(3));
			System.out.println(toPigLatin("apple"));
			System.out.println(toPigLatin("therapy"));
			System.out.println(toPigLatin("yellow"));
			System.out.println(encode("bvh"));
			System.out.println(encode("The quick brown fox jumps over the lazy dog."));
			System.out.println(encode("mindblowingly"));
			System.out.println(encode("Testing,1 2 3, testing."));
			System.out.println(isValidIsbn("3-598-21508-8"));
			System.out.println(isValidIsbn("3-598-21508-9"));
			System.out.println(isValidIsbn("3-598-21507-X"));
			System.out.println(isValidIsbn("3-598-21507-A"));
			System.out.println(isValidIsbn("3-598-2K507-0"));
			System.out.println(isPangram(""));
			System.out.println(isPangram("abcdefghijklmnopqrstuvwxyz"));
			System.out.println(isPangram("the quick brown fox jumps over the lazy dog"));
			System.out.println(isPangram("a quick movement of the enemy will jeopardize five gunboats"));
			System.out.println(isPangram("five boxing wizards jump quickly at it"));
			int set[] = { 5,6,8 };
			System.out.println(getSumOfMultiples(150, set));
			System.out.println(solveWordProblem("5 plus 6"));
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
	
	public static String acronym(String phrase) {
		String acro = "";
		for(int i = 0; i<phrase.length(); i++) {
			if(i == 0 && phrase.charAt(0) != ' ') {
				acro += phrase.charAt(i);
			}else if(phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') {
				acro += phrase.charAt(i+1);
			}
		}
		acro = acro.toUpperCase();
		return acro;
	}

	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(getSideOne() == getSideTwo() && getSideOne() == getSideThree()) {
				return true;
			}else {
			return false;
			}
		}

		public boolean isIsosceles() {
			if(getSideOne() == getSideTwo() || getSideOne() == getSideThree() || getSideTwo() == getSideThree()) {
				return true;
			}else {
			return false;
			}
		}

		public boolean isScalene() {
			if(getSideOne() == getSideTwo() || getSideOne() == getSideThree() || getSideTwo() == getSideThree()) {
				return false;
			}else {
			return true;
			}
		}

	}
	
	public static int getScrabbleScore(String string) {
		int score = 0;
		for(int i = 0; i < string.length(); i++) {
			char letter = string.charAt(i);
			switch(letter) {
			case 'A':
			case 'a':
			case 'E':
			case 'e':
			case 'I':
			case 'i':
			case 'O':
			case 'o':
			case 'U':
			case 'u':
			case 'L':
			case 'l':
			case 'N':
			case 'n':
			case 'R':
			case 'r':
			case 'S':
			case 's':
			case 'T':
			case 't':
				score+=1;
				break;
			case 'D':
			case 'd':
			case 'G':
			case 'g':
				score+=2;
				break;
			case 'B':
			case 'b':
			case 'C':
			case 'c':
			case 'M':
			case 'm':
			case 'P':
			case 'p':
				score+=3;
				break;
			case 'F':
			case 'f':
			case 'H':
			case 'h':
			case 'V':
			case 'v':
			case 'W':
			case 'w':
			case 'Y':
			case 'y':
				score+=4;
				break;
			case 'K':
			case 'k':
				score+=5;
				break;
			case 'J':
			case 'j':
			case 'X':
			case 'x':
				score+=8;
				break;
			case 'Q':
			case 'q':
			case 'Z':
			case 'z':
				score+=10;
				break;
			}
		}
		return score;
	}
	
	public static Map<String, Integer> wordCount(String string) {
		int count = 0;
		Map<String, Integer> wordCounter = new ConcurrentHashMap<>();
		String noPunctuation = string.replaceAll("/n", " ");
		noPunctuation.replaceAll("[^a-zA-Z]", " ");
		while(count < noPunctuation.length()) {
			String placeholder = "";
			for(int i = count; i<noPunctuation.length();i++) {
				if(noPunctuation.charAt(i) == ' ') {
					count++;
					break;
				}else {
					placeholder += noPunctuation.charAt(i);
					count++;
				}
			}
			if(wordCounter.isEmpty() == false) {
			if(placeholder != "") {
				for(String key : wordCounter.keySet()) {
					if(placeholder.equals(key)) {
						int value = wordCounter.get(key);
						value++;
						wordCounter.put(key, value);
						break;
					}else {
						wordCounter.put(placeholder, 1);
					}
				}
			}
			}else {
				wordCounter.put(placeholder, 1);
			}
	}
	return wordCounter;
}

	public static boolean isArmstrongNumber(int input) {
		String numString = Integer.toString(input);
		int count = numString.length();
		int sum = 0;
		for(int i = 0; i < count; i++) {
			 char placeholder = numString.charAt(i);
			 int intplaceholder = Character.getNumericValue(placeholder);
			 sum += Math.pow(intplaceholder, count);
		}
		if(sum == input) {
			return true;
		}else {
		return false;
		}
	}
	
	public static List<Long> calculatePrimeFactorsOf(long l) {
		List<Long> list = new ArrayList<Long>();
		if(l == 2) {
			list.add(l);
		}
		for(long i = 2; i < l; i++) {
			if(l % i == 0) {
					long checkPrime = i;
					int checker = 0;
					for(long j = 2; j < checkPrime; j++) {
						if(checkPrime % j == 0) {
							checker = 1;
						}
					}
					if(checker == 0) {
						list.add(checkPrime);
					}
			}
		}
		return list;
	}
	
	public static int calculateNthPrime(int i) {
		int count = 1;
		int placeholder = 2;
			for(int j = 3; j < 2147483647; j++) {
				int otherPlaceholder = 0;
				for(int k = 2; k < j; k++) {
					if(j % k == 0) {
						otherPlaceholder = 1;
					}
				}
			if(otherPlaceholder == 0) {
				placeholder = j;
				count++;
				if(count == i) {
					break;
				}
			}
			}
		return placeholder;
	}

	public static String toPigLatin(String string) {
		String placeholder = "";
		switch(string.charAt(0)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			placeholder += string;
			placeholder += "ay";
		default:
			if(placeholder == "") {
				String stringBegin = "";
				for(int i = 0; i < string.length(); i++) {
					switch(string.charAt(i)) {
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
						for(int j = i; j<string.length(); j++) {
							placeholder += Character.toString(string.charAt(j));
						}
						placeholder += stringBegin + "ay";
						return placeholder;
					default:
						stringBegin += Character.toString(string.charAt(i));
					}
				}
			}
		}
		return placeholder;
	}
	
	public static String encode(String string) {
		String alpha = "0123456789abcdefghijklmnopqrstuvwxyz";
		String reverse = "0123456789zyxwvutsrqponmlkjihgfedcba";
		String placeholder = "";
		string = string.replaceAll("[^a-zA-Z0-9]", "");
		string = string.toLowerCase();
		for(int i = 0; i < string.length(); i++) {
			char character = string.charAt(i);
			int index = alpha.indexOf(character);
			placeholder += Character.toString(reverse.charAt(index));
			if((i+1) % 5 == 0) {
				placeholder += " ";
			}
		}
		return placeholder;
	}
	
	public static boolean isValidIsbn(String string) {
		String noHyphens = string.replaceAll("-", "");
		int sum = 0;
		int multiplier = 10;
		for(int i = 0; i < noHyphens.length(); i++) {
			int currentNum = 0;
			if(noHyphens.charAt(i) == 'X') {
				currentNum = 10;
			}else if(Character.isDigit(noHyphens.charAt(i)) == false){
				return false;
			}else {
			currentNum = Character.getNumericValue(noHyphens.charAt(i));
			}
			sum += currentNum * multiplier;
			multiplier--;
		}
		if(sum % 11 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isPangram(String string) {
		List<Character> alphabet = new ArrayList<Character>(Arrays.asList('a','b','c',
				'd','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u',
				'v','w','x','y','z'));
		for(int i = 0; i < string.length(); i++) {
			char letter = string.charAt(i);
			Iterator<Character> lookAtAlphabet = alphabet.iterator();
			while(lookAtAlphabet.hasNext()) {
				if(letter == lookAtAlphabet.next()) {
					lookAtAlphabet.remove();
				}
			}
		}
			if(alphabet.isEmpty()) {
				return true;
			}else {
				return false;
			}
	}
	
	public static int getSumOfMultiples(int i, int[] set) {
		int sum = 0;
		for(int j = i-1; j >= 1; j--) {
			for(int k = 0; k < set.length; k++) {
				int checker = 0;
				if(j % set[k] == 0) {
				sum += j;
				checker++;
				}
				if(checker == 1) {
					break;
				}
			}
		}
		return sum;
	}
	
	public static int solveWordProblem(String string) {
		List<String> problem = new ArrayList<String>();
		String[] words = string.split(" ");
		int[] numbers = new int[2];
		String operand = "";
		int answer = 0;
		int count = 0;
		for(int i = 0; i < words.length; i++) {
	        try 
	        { 
	            Integer.parseInt(words[i]); 
	            if(count == 0) {
	            	numbers[0] = Integer.parseInt(words[i]);
	            	count++;
	            }else {
	            	numbers[1] = Integer.parseInt(words[i]);
	            }
	        }  
	        catch (NumberFormatException e)  
	        { 
	            switch(words[i]) {
	            case "plus":
	            	operand = "plus";
	            	break;
	            case "minus":
	            	operand = "minus";
	            	break;
	            case "multiplied":
	            	operand = "multiplied";
	            	break;
	            case "divided":
	            	operand = "divided";
	            	break;
	            
	            }
	        }
		}
		if(operand == "plus") {
			answer = numbers[0] + numbers[1];
		}else if(operand == "minus") {
			answer = numbers[0] - numbers[1];
		}else if(operand == "multiplied") {
			answer = numbers[0] * numbers[1];
		}else {
			answer = numbers[0] / numbers[1];
		}
		
		return answer;
	}
}


