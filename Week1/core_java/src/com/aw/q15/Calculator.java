package com.aw.q15;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		//Create object
		System.out.println("Place in a value, press Enter");
		Scanner inputs = new Scanner(System.in);
		int first =inputs.nextInt();
		System.out.println("Place in a second value, press Enter");
		int second =inputs.nextInt();
		
		CalculatorImplements testing = new CalculatorImplements();
		
		//Display result
		System.out.println("Adding: "+ testing.addition(first, second));
		System.out.println("Subtracting: " +testing.substraction(first, second));
		System.out.println("Dividing: " +testing.division(first, second));
		System.out.println("Multiplying: " +testing.multiplication(first, second));
	}

}
