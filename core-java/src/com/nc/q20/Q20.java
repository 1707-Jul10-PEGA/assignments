package com.nc.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
	public static void main(String[] args) throws IOException {
		//Name of file
		String fileName = "Data.txt";
		//Store each line in txt
		String line = null;
		
		//So I can read files
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		//Loops stop when there is no more lines
		while((line = bufferedReader.readLine()) != null) 
		{
			//Split the string of word into an array of string 
			String[] word = line.split(":");
			//Display results
			System.out.println("Name: " + word[0] + " " + word[1]);
			System.out.println("Age: " + word[2] + " years");
			System.out.println("State: " + word[3] + " State\n");
        }   
		bufferedReader.close(); 
		
	}
}
