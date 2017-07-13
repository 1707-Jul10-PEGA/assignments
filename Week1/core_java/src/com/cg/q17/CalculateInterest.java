package com.cg.q17;

import java.util.Scanner;

public class CalculateInterest {
	public static void main(String [] args){
		double interest;
		double principal;
		double rate;
		int time;
		
		Scanner scan = new Scanner(System.in);
		
		do{
			try{
				System.out.print("Enter principal:");
				principal = Double.parseDouble(scan.nextLine());
				break;
			}catch(NumberFormatException e){
				continue;
			}
			
		}while(true);
		
		do{
			try{
				System.out.print("Enter rate:");
				rate = Double.parseDouble(scan.nextLine());
				break;
			}catch(NumberFormatException e){
				continue;
			}
			
		}while(true);
		
		do{
			try{
				System.out.print("Enter life of the loan(years):");
				time = Integer.parseInt(scan.nextLine());
				break;
			}catch(NumberFormatException e){
				continue;
			}
			
		}while(true);
		
		interest = principal * rate * time;
		System.out.println("Interest = " + interest);
		scan.close();
	}
}
