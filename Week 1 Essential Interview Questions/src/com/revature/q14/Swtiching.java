package com.revature.q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class Swtiching {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Hello! You have options.\n Enter \"1\" for the square root calulator. \n Enter \"2\" for today's date. \n Enter \"3\" to split up the string \"I am learning core Java (even though I feel like I know nothing the more I learn :)\" \n");
	
		int toSwitch = scan.nextInt();
		scan.close();
		switch(toSwitch){
			case 1:
			{
				System.out.println("You have chosen to square root calculator. Enter which number you'd like to root: \n: ");
				int toRoot = scan.nextInt();
				System.out.println("The square root of " + toRoot + " is: " + Math.sqrt(toRoot));
				break;
			}
			case 2: 
			{
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				
				System.out.println("You have chosen to display the date. The time and date at this location is: " + dateFormat.format(date));
				break;
			}
			case 3:
			{
				System.out.println("You've chosen to split up the string \"I am learning core Java\" into a string array. Here goes...");
				String toSplit = "I am learning core Java";
				String[] splitUp = toSplit.split("");
				for(int x = 0; x < splitUp.length; x++){
						System.out.print(splitUp[x]);
					}
			}
		}
	}
	
}
