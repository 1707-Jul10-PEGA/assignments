package com.MS.Q20.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileRW {

	
	private static final String FILENAME = "C:\\Revature\\Q20input.txt";

	
	/*
	 * The main function creates a FileReader and a BufferedReader. The 
	 * FR reads each individual character while the BR stores those chars
	 * until it hits a line end. The stored string is then split into a
	 * string array and printed out to the screen with descriptions of 
	 * their assorted parts.
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			String currentLine;
			String[] info;
			
			br = new BufferedReader(new FileReader(FILENAME));
			
			while ((currentLine = br.readLine()) != null) {
				info = currentLine.split(":");
				System.out.println("Name: " + info[0] + " " + info[1]);
				System.out.println("Age: " + info[2] + " years");
				System.out.println("State: " + info[3] + " State");
				System.out.println("");
				
			}
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
