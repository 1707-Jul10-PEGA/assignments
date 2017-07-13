package com.EC.q18;

public class Q18 {

	public static void main(String[] args){
		
		String str = "EllioT";
		String str2 = "10";
		Q18Abstract dao = new Q18SubClass();
		System.out.println("Original String1: " + str);
		System.out.println("Original String2: " + str2);
		
		System.out.println("String \"EllioT\" has uppercase letters: " + dao.hasUpperCase(str));
		System.out.println("Convert string \"EllioT\" to all uppercase: " + dao.toUpperCase(str));
		System.out.println("Convert str2: \"10\" to an Interger and add 10: " + dao.toIntPlusTen(str2));
		
		
		
	}
}
