package com.WL.q18;

import java.util.ArrayList;

public class Q18 {
	
	//Driver class to test my Q 18 Solutions
	public static void main(String[] args) {
		
		ArrayList<String> testers = new ArrayList<String>();
		testers.add("12344555");
		testers.add("thisisalllowercase");
		testers.add("ThisHasUpperCase");
		testers.add("THISISUPPERCASE");
		testers.add("MIXED10VALUES");
		testers.add("3VALUes83219a.4");
		testers.add(" ");
		testers.add("_-+=");
		MyConcrete myTest = new MyConcrete();
		for(String s: testers)
		{
			System.out.println(s);
			System.out.println(myTest.containsUpperCase(s));
			System.out.println(myTest.convertLowerCase(s));
			System.out.println(myTest.convertToIntWith10(s));
			System.out.println(" ");
		}
	}

}
