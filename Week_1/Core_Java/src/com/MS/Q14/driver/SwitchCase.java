package com.MS.Q14.driver;

import java.util.Scanner;
import java.util.Date;

public class SwitchCase {

	/*
	 * The main function is a larger code statement this time (I did not think
	 * it would get this large, hence why I left it in main) Instantiate various
	 * variables and arrays for loops. Then, print and ask for an input integer
	 * of 1,2, or 3.
	 */
	public static void main(String[] args) {
		
		String tosplit = "I am learning Core Java";
		String[] split = {"Filler","Filler","Filler","Filler","Filler","Filler"};
		int count = 1;
		int previous = 0;
		int[] arrayindex = {0,0,0,0,0,0,0};
		int x = 66;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1: Find sqrt of " + x);
		System.out.println("2: Display today's date ");
		System.out.println("3: Split a string into a string array");
		System.out.println("Please enter a number: ");
		int scannedInt = scan.nextInt();
		
		
		/*
		 * The switch structure runs a sqrt function of a preset integer if
		 * 1 is pressed, displays the date and time if 2 is pressed, and
		 * splits a String statement if 3 is pressed.
		 */
		switch(scannedInt)
		{
		case(1):
		{
			System.out.println("The sqrt of " + x + " is " + Math.sqrt(x));
			break;
		}
		case(2):
		{
			Date date = new Date();
			System.out.println("Today is ");
			System.out.print(date);
			break;
		}
		case(3):
		{
			//First part searches for whitespace in the string and records the char it was at
			for(int i=0; i<tosplit.length();i++)
			{

				
				if(tosplit.charAt(i) == 32)
				{
					System.out.println("Found whitespace at char " + i);
					arrayindex[count] = i;
					count++;
				}
			}
			
			/*System.out.println(arrayindex[0]);
			System.out.println(arrayindex[1]);
			System.out.println(arrayindex[2]);
			System.out.println(arrayindex[3]);
			System.out.println(arrayindex[4]);
			System.out.println(arrayindex[5]);
			System.out.println(arrayindex[6]);*/
			
			/*It then resets the counter variable and creates substrings based off
			 * of the stored character locations. It also prints out the truncated
			 * string and stores it in a string array.
			 */
			count = 1;
			for(int i=0; i<4;i++)
			{
				if(i==0)
				{
					split[i] = tosplit.substring(arrayindex[previous], arrayindex[count]+1);
					System.out.println(split[i].toCharArray());
					previous = count;
					count++;
				}
				else
				{
				split[i] = tosplit.substring(arrayindex[previous]+1, arrayindex[count]+1);
				System.out.println(split[i].toCharArray());
				previous = count;
				count++;
				}
			}
			//Cover the final word, since we just want the leftovers from last count
			split[count] = tosplit.substring(arrayindex[count-1]+1);
			System.out.println(split[count].toCharArray());
			
			break;
		}
		}
		/*
		 * In hindsight, it would have been FAR easier to use the string.split() method,
		 * but I did not know that function existed. That method is used in Q20, and I 
		 * did not want to break this code accidentally.
		 */
		

		
	}

}
