package com.nc.q6;

import java.util.Scanner;

public class Q6 {
	public static void main(String[] args) {
		//Ask and get int
		System.out.print("Please type an Int: ");
		Scanner sc = new Scanner(System.in);
		float num = sc.nextFloat();
		
		//Might or might not get a decimal
		float test = num / 2;
		//Remove any decimal from test
		int compare = (int)test;
		//Subtract to see if decimal remains
		test = test - compare;
		//No decimal exist
		if(test == 0)
		{
			System.out.println("Your number is even");
		}
		//Decimal exist
		else
		{
			System.out.println("Your number is odd");
		}
	}
}
