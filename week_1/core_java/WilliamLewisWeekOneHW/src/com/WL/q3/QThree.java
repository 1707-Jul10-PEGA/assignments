package com.WL.q3;

public class QThree {
	//Reverse a string without use of a temp variablew

	public static void main(String[] args) {
		reverse("BIGLONGSTRING");
	}
	
	public static String  reverse(String myString){
		
		
		
		for(Character c: myString.toCharArray()){
			myString = c+myString;
		}
		myString=myString.substring(0, myString.length()/2);
		System.out.println(myString);
		return myString;
	}

}
