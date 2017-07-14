/*
 * Tae Song
 * Question 20
 */
package com.TS.Q20.driver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;

public class Main {

	public static void main(String[] args) {
		char[] buffer = new char[255];	//buffer for characters read from the file
		int newlineCount = 0;			//Used to count newlines
		
		/*reads data and initializes array of characters*/
		readData(buffer);
		
		/*Counts newlines to be used for for loop*/
		for(int i = 0; i < buffer.length; i++)
		{
			if (buffer[i] == '\n')
			{ newlineCount += 1; }
		}
		
		/*prints out the data in the specified format*/
		int counter = 0;
		int iterator = 0;
		for(int i = 0; i <= newlineCount; i++)
		{
			System.out.print("Name: ");
			while(counter < 2)
			{
				if(Character.isLetter(buffer[iterator]))
				{ System.out.print(buffer[iterator]); }
				else
				{ 
					counter = counter + 1;
					System.out.print(" ");
				}
				iterator = iterator + 1;
			}
			if (counter == 2)
			{
				counter = 0;
			}
			System.out.println();
			
			System.out.print("Age: ");
			while(Character.isDigit(buffer[iterator]))
			{
				System.out.print(buffer[iterator]);
				iterator = iterator + 1;
			}
			System.out.print(" years\n");
			
			iterator = iterator + 1;
			System.out.print("State: ");
			while(Character.isLetter(buffer[iterator]))
			{
				System.out.print(buffer[iterator]);
				iterator = iterator + 1;
			}
			System.out.print(" State\n");
			iterator = iterator + 2;
			System.out.println();
		}
	}
	
	private static String filename = "Data.txt";
	
	/* readData
	 * 
	 * takes in an array of characters and initializes it with the read data from filename
	 * 
	 * returns the array of characters
	 */
	public static char[] readData(char[] c)
	{
		try(FileReader ois = new FileReader(filename)){
			ois.read(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
