package com.HL.q4;

import java.util.Scanner;

public class Question4
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your number: ");
		int n=scan.nextInt();
		scan.close();
		int result=1;
		for(int i=1; i<=n; i++)
		{
			result = result*i;
		}
		System.out.println("The factorial of "+n+" is: "+result);
	}
}
