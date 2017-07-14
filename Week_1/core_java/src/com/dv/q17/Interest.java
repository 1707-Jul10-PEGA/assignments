package com.dv.q17;

import java.util.*;

public class Interest {

	public static void main(String[] args) {
		double principal, rate, interest;
		int years;
		
		Scanner read = new Scanner(System.in);
		
		System.out.println("Enter principal: ");
		principal = read.nextDouble();

		System.out.println("Enter rate: ");
		rate = read.nextDouble();

		System.out.println("Enter years: ");
		years = read.nextInt();
		
		interest = principal*rate*years;
		
		System.out.println("Your interest: $" + principal + " * " + rate + " * " + years + " years");
		System.out.println("= " + interest);
	}

}
