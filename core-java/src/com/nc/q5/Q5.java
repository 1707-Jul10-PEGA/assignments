package com.nc.q5;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
			//The ask and get the str and idx
			System.out.print("Please type a String: ");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			System.out.print("Please type an Int: ");
			int idx = sc.nextInt();
			
			//Display result
			System.out.println(substring(str, idx));
	   }

	   //Return a substring
	   public static String substring(String str, int idx) {
		   //How do I return a substring without using substring
		   String subStr = str.substring(0, idx -1);
		   return subStr; 
	   }
}