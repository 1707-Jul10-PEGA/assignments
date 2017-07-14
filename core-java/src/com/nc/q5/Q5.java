package com.nc.q5;

import java.util.ArrayList;
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
			str = substring(str, idx);
			System.out.println(str);
	   }

	   //Return a substring
	   public static String substring(String str, int idx) {
		   //convert string to array
		   char[] word = str.toCharArray();
		   //hold substring
		   ArrayList subSTR = new ArrayList();
		   //put the substring into the holder
		   for(int x = 0; x <= idx-1; x++)
		   {
			   subSTR.add(word[x]); 
		   }
		   //Return result
		   str = subSTR.toString();
		   return str;
	   }
}