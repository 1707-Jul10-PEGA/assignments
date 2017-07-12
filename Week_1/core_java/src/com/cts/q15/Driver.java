//Carson Stephens
//07-11-2017

package com.cts.q15;

import java.util.Scanner;

//interface for operations
interface Operations
{
	float add(float x, float y);
	float sub(float x, float y);
	float mul(float x, float y);
	float div(float x, float y);
}

class Calculator implements Operations
{
	//Add x and y, print, and return result
	public float add(float x, float y)
	{
		float result = x+y;
		System.out.println(x + " + " + y + " = " + result);
		return result;
	}
	
	//Subtract x and y, print, and return result
	public float sub(float x, float y)
	{
		float result = x-y;
		System.out.println(x + " - " + y + " = " + result);
		return result;
	}
	
	//Multiply x and y, print, and return result
	public float mul(float x, float y)
	{
		float result = x*y;
		System.out.println(x + " * " + y + " = " + result);
		return result;
	}
	
	//Divide x and y, print, and return result
	public float div(float x, float y)
	{
		float result = x/y;
		System.out.println(x + " / " + y + " = " + result);
		return result;
	}
	
	//Take operands and interpret input for operations
	public float calc(float x, float y)
	{
		//Initialize result
		float result = 0;
		
		//Initialize operator input to 1
		int op = 1;
		
		//Set up a scanner for input
		try (Scanner scanner = new Scanner(System.in))
		{
			while (op != 0)
			{
				//Take user input, mapping [1, 4] to respective operations
				//0 to quit
				System.out.println("1: Addition\n2: Subtraction\n3: Multiplication\n4: Division\n0: Quit");
				op = scanner.nextInt();
				
				//Switch case for operations 
				switch (op)
				{
					//Addition
					case 1: 
						result = add(x, y);
						break;
					
					//Subtraction
					case 2:
						result = sub(x, y);
						break;
						
					//Multiplication
					case 3:
						result = mul(x, y);
						break;
					
					//Division
					case 4:
						result = div(x, y);
						break;
					
					//Default case (does nothing)
					default:
						break;
				}
			}
		}
		
		//Return result of operation
		return result;
	}
}

public class Driver
{
	public static void main(String[] args)
	{
		System.out.println("Q15");
		
		//Hard code of two operands
		float x = 3;
		float y = 5;
		
		//Declare a new Calculator
		Calculator c = new Calculator();
		
		//Call interface with two operands
		c.calc(x, y);
	}
}