package com.WL.q3;

public class QThree {
	//Reverse a string without use of a temp variable

	public static void main(String[] args) {
		reverse("BIGLONGSTRING");
	}
	
	public static String  reverse(String myString){
		
		
		//Place each character of the string at the front
		for(Character c: myString.toCharArray()){
			myString = c+myString;
		}
		//cut string down to appropriate length and cut
		myString=myString.substring(0, myString.length()/2);
		System.out.println(myString);
		return myString;
	}

}
