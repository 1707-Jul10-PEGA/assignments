package com.revature.q4;

import java.util.Scanner;

public class Factorial {
	public static double factComp(long input){
		if(input == 1){
			return input;
		}
		else{
			return input * factComp(input - 1);
		}
	}
	public static void main(String[] args)
	{
		System.out.println("Hello!. Enter the number to be factorialized, even though that probably isn't a word.");
		Scanner sIn = new Scanner(System.in);
		
		double result;
		int toFact = sIn.nextInt();
		
		result = factComp(toFact);
		if(toFact <= 10){
		System.out.println("Thanks!");
		System.out.println(toFact + " factorialized is " + (int)result);
		}
		else{
			System.out.println("Thanks!");
			System.out.println(toFact + " factorialized is " + result);
		}
		sIn.close();
	}
}
