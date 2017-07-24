package com.HL.q6;

import java.util.Scanner;

public class Question6
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your number:");
		int myInt = scan.nextInt();
		if((myInt/2)*2 == myInt)
		{
			System.out.println("Your number is even.");
		}
		else
		{
			System.out.println("Your number is odd.");
		}
		scan.close();
	}
}
