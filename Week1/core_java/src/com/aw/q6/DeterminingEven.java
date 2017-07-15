package com.aw.q6;

import java.util.Scanner;

public class DeterminingEven {
	
	public static void main(String[]args){
	Scanner input = new Scanner(System.in);
	System.out.println("Please enter an INTEGER value into the console and press Enter on your keyboard.");
	int valueToBeChecked = input.nextInt();
	int checker = valueToBeChecked / 2;
	double checker2 = valueToBeChecked / 2.0;
	if (checker == checker2) { // == is a reference comparison and compares objects at a location
			System.out.println("The value is an even number");			
	//System.out.println(valueToBeChecked);
	}else {
		System.out.println("The value is an odd number");
		}
	//System.out.println(valueToBeChecked);
	}
}