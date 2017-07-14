package com.MS.Q17.driver;

import java.util.Scanner;

public class InterestCalc {

	/*
	 * The main function sets up the variables and contains the methods
	 * to input various values to them. It then sets the variables to the
	 * supplied values and calculates the generated interest as well as
	 * the final value.
	 */
	public static void main(String[] args) {

		InterestCalc example = new InterestCalc();

		double principal = 0;
		double rate = 0;
		double time = 0;
		
		principal = example.inputscan(1);
		rate = example.inputscan(2);
		time = example.inputscan(3);
		System.out.println("The value of generated interest is: $" + principal*rate*time);
		System.out.println("The final value (with interest) is: $" + (principal*rate*time + principal));
		
		
		
	}

	/*
	 * The inputscan method operates on a case system, which simply goes in order.
	 * This way, part of the code is recycled but the outputted messages are different.
	 * It also records and returns an inputted integer each time it runs.
	 */
	public double inputscan(int i)
	{
		switch(i)
		{
		case(1):
		{
			System.out.println("Please enter the principal: ");
			break;
		}
		case(2):
		{
			System.out.println("Please enter the rate: ");
			break;
		}
		case(3):
		{
			System.out.println("Please enter the time elapsed: ");
			break;
		}
		default:
		{
			break;
		}
		}
		
		Scanner scan = new Scanner(System.in);
		double scannedDouble = scan.nextDouble();
		
		return scannedDouble;
	}
}
