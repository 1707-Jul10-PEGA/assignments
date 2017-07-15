package com.aw.q4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[]args){
		Scanner integerInput = new Scanner(System.in);
		int answer = 1;
		int input = integerInput.nextInt();
		//int tempX = input;
		{for (int x = 1; x <= input; x++){
			answer = answer *x;
			;}
		System.out.println(answer);
			} 	
		
	}
}
