//Carson Stephens
//07-11-2017

package com.cts.q17;

import java.util.Scanner;

public class Driver
{
	
	public static void main(String[] args)
	{
		System.out.println("Q17");
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			//User input for principal in dollars
			System.out.print("Principal: $");
			double p = scanner.nextDouble();
			
			//User input for rate in percentage, dividing by 100
			System.out.print("Rate (%): ");
			double r = scanner.nextDouble() / 100.0;
			
			//User input for time in years
			System.out.print("Time (yr): ");
			double t = scanner.nextDouble();
			scanner.nextLine();
			
			//Calculate interest by Interest = Principal * Rate * Time
			double i = p*r*t;
			System.out.println("Interest: $" + i);
		}
	}
}
