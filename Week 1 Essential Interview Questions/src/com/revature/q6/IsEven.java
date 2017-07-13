package com.revature.q6;

public class IsEven {
	
	public static void main (String[] args){
		
		int x = 14789;
		StringBuilder mySB = new StringBuilder();
		mySB.append(x);
		
		int result = evenTester(mySB);
		System.out.println(result);
		if(result == 1)
		{
			System.out.println("Thanks!" + x + " is an even number.");
		}
		else
		{
			System.out.println("Thanks!" + x + " is not an even number.");
		}
		
	}
	private static int evenTester(StringBuilder input) {
		
		int output;
		System.out.println(input.length());
		int test = (int)input.charAt(4);
		System.out.println(test);
		switch(test){
		case 1:
		case 3:
		case 5:
		case 7:
		case 9:
			output = 0;
			break;
		default:
			output = 1;
			break;
		}
		
		return output;
	}
}
