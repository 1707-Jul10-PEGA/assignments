package com.HL.q10;

import java.util.Scanner;

public class Question10
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first number: ");
		double d1 = scan.nextDouble();
		System.out.println("Enter the second number: ");
		double d2 = scan.nextDouble();
		double minVal = (d1<d2) ? d1:d2;
		System.out.println("The smaller number is: "+minVal);
		scan.close();
	}
}
