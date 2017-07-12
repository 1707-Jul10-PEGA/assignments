package com.nc.q3;
import java.util.*;

public class Q3 {
	public static void main(String[] args) {
		//The ask and get the string to reverse
		System.out.print("Please type a String to reverse: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();  
		//Number of loop done is the number of char in the string
		for(int x = 0; x < str.length(); x++)
		{
			//Just testing how substring works
			/*String test = str.substring(1, str.length() - x);
			System.out.println(test);
			test = str.substring(0, 1);
			System.out.println(test);
			test = str.substring(str.length() - x, str.length());
			System.out.println(test);*/
			
			//Move all but the fist and already moved char to the front
			str = str.substring(1, str.length() - x) + 
			/*Grab and add the current first char to the end*/
					str.substring(0, 1) + 
			/*Grab and add the chars that has already been moved to the end*/
					str.substring(str.length() - x, str.length());

		}
		System.out.println(str);
	}
}
