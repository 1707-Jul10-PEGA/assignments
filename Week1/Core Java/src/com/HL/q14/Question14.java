package com.HL.q14;

import java.util.Date;
import java.util.Scanner;

public class Question14
{
	public static void main(String[] args)
	{
		System.out.println("Case choices: \n1: Find a square root.\n2: Display today's date.\n3: Split a provided string.\n");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your case:");
		int myCase=scan.nextInt();
		switch(myCase)
		{
		case 1: myCase = 1;
		{
			System.out.println("Enter a number to find square root:");
			double myNum = scan.nextDouble();
			System.out.println("The square root of your number is: "+Math.sqrt(myNum));
			break;
		}
		case 2: myCase = 2;
		{
			Date date = new Date();
			System.out.println("Today's date is "+date);
			break;
		}
		case 3: myCase = 3;
		{
			String myStr = "I am learning Core Java";
			String[] myArr = myStr.split(" ");
			System.out.println("Splitted string is:");
			for(int i=0; i<myArr.length; i++)
			{
				System.out.println(myArr[i]);
			}
			break;
		}
		default: 
			System.out.println("Invalid case!");
			break;
		}
		scan.close();
	}
}
