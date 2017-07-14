package com.hy.q17.driver;

import java.util.Scanner;

public class Question17 {
	private double calculateInterest(){
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the principal amount?");
		double p = sc.nextDouble();
		System.out.println("What is the rate of interest?");
		double r = sc.nextDouble();
		System.out.println("What is the time frame in years?");
		double t = sc.nextDouble();
		double i = p*r*t;
		System.out.println("Simple Interest = " + i);
		return i;
		
	}
	
	public static void main(String[] args) {
		new Question17().calculateInterest();
	}
}
