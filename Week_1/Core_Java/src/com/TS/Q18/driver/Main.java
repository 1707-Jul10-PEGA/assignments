package com.TS.Q18.driver;

public class Main {

	/*
	 * Tests the 3 methods implmented in SubClassDemonstration class
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubClassDemonstration Q18 = new SubClassDemonstration();
		String test = "TesT";
		String numberTest = "20";
		
		/*Testing checkUppercase method*/
		if(Q18.checkUppercase(test))
		{ System.out.println("This string contains an uppercase letter"); }
		else
		{ System.out.println("This string does not contain an uppercase letter"); }
		
		/*Testing toUppercase method*/
		System.out.println(Q18.toUppercase(test));
		
		/*Testing printAsNumber method*/
		System.out.println(Q18.printAsNumber(numberTest));
	}
}
