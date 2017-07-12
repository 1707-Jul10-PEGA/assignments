package com.rb.q17.driver;

import java.util.Scanner;

public class InterestCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanIn = new Scanner(System.in);
		
		System.out.print("Input principal: ");
		int prin = scanIn.nextInt();
		System.out.print("Input rate (5% input 0.05): ");
		float rate = scanIn.nextFloat();
		System.out.print("Input time: ");
		int time = scanIn.nextInt();
		
		float interest = prin * rate * time;
		
		System.out.format("Interest paid = %.2f", interest);
		scanIn.close();
	}

}
