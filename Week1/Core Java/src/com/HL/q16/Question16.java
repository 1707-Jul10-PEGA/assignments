package com.HL.q16;

import java.util.Scanner;

public class Question16
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String[] args1 = new String[1];
		System.out.println("Enter your string: ");
		args1[0] = scan.nextLine();
		System.out.println("There are "+args1[0].replaceAll("\\s","").length()+" characters in your string.");
		scan.close();
	}
}
