package com.HL.q17;

import java.util.Scanner;

public class Question17
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your principal:");
		double principal = scan.nextDouble();
		System.out.println("Enter your rate:");
		double rate = scan.nextDouble();
		System.out.println("Enter your time in years:");
		double time = scan.nextDouble();
		double interest = principal*rate*time;
		System.out.println("Your interest is: "+interest);
		scan.close();
	}
}
