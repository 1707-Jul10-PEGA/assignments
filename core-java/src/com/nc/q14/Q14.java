package com.nc.q14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class Q14 {
	public static void main(String[] args) {
		//Get user input
		System.out.print("Type either 1, 2, or 3: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		switch (num) 
		{
			case 1:	
				//Create random number from 1 to 50
				Random rand = new Random();
				int  randomNum = rand.nextInt(50) + 1;
				//square root the number
				System.out.println("The square root of a random number " + randomNum + " is " + Math.sqrt(randomNum));
				break;
			case 2:	
				//Get and print the date
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate localDate = LocalDate.now();
				System.out.println("The date is " + dtf.format(localDate));
				break;
			case 3:	
				//Create string
				String str = "I am learning Core Java";
				//Split string into an array of string
				String[] strArray = str.split("\\s");
				System.out.println("The string \"" + str + "\" is split into ");
				//Display results
				for(int x = 0; x < 5; x++)
				{
					System.out.println(strArray[x]);
				}
				break;
		}
	}
}
