package com.revature.q18;

public class Driver {
	public static void main(String[] args) {
		String testIsUpperThere = "isThisWorking?";
		String testIsUpperThere2 = "yesitis";
		
		Concrete myC = new Concrete();
		boolean b1 = myC.isUpperThere(testIsUpperThere);
		boolean b2 = myC.isUpperThere(testIsUpperThere2);
		
		System.out.println(b1 + " " + b2);
		
		String testLowUp = "abDceFG";
		String result1 = myC.toUpperCase(testLowUp);
		System.out.println(result1);
		
		String ten = "10";
		myC.toInterPlusTen(ten);
	}
}
