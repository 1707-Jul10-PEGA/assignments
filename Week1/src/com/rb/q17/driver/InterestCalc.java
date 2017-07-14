package com.rb.q17.driver;

import java.util.Scanner;

public class InterestCalc {

	public static void main(String[] args) {
		
		// create a scanner and then prompt inputs, read in information
		
		Scanner scanIn = new Scanner(System.in);
		
		System.out.print("Input principal: ");
		int prin = scanIn.nextInt();
		System.out.print("Input rate (5% input 0.05): ");
		float rate = scanIn.nextFloat();
		System.out.print("Input time: ");
		int time = scanIn.nextInt();
		scanIn.close();
		
		// create float that is the product of the rate,
		// principle, and time.
		float interest = prin * rate * time;
		
		//print out result
		System.out.format("Interest paid = %.2f", interest);
		
	}

}
