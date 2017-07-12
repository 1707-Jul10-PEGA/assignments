package com.nc.q4;
import java.util.*;

public class Q4 {
	public static void main(String[] args) {
		//The ask and get the int to factorial
		System.out.print("Please type an int number: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int factorial = 1;
		
		//number if loops equal the size of number
		for(int x = 1; x <= number; x++)
		{
			//Starting at 1, each loop multiply itself by one more
			factorial *= x;
		}
		//Can't compute large numbers
		System.out.println(factorial);
	}
}
