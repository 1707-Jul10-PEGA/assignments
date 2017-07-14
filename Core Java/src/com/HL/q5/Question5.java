package com.HL.q5;

import java.util.Scanner;

public class Question5
{
	public static String myMethod(String str, int idx)
	{
		String resultString = "";
		for(int i=0; i<idx; i++)
		{
			resultString += str.charAt(i);
		}
		return resultString;
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your string: ");
		String myStr = scan.nextLine();
		System.out.println("Enter your index: ");
		int myIndex = scan.nextInt();
		System.out.println("Your substring is: ");
		System.out.println(myMethod(myStr, myIndex));
		scan.close();
	}
}
