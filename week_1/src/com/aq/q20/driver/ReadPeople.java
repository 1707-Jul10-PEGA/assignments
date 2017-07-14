package com.aq.q20.driver;

import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class ReadPeople {
	public static void main(String[] args) {
		String file = "people.txt";
		String line = "";	
		try {
			FileReader fileReader = new FileReader(file);		
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String name = "";
			String age = "";
			String state = "";
			
			while(((line = bufferedReader.readLine()) != null )) {
				String[] fields = line.split(":");

				name = "Name: " + fields[0] + " " + fields[1];
				age = "Age: " + fields[2] + " years";
				state = "State: " + fields[3] + " State";
				
				System.out.println(name);
				System.out.println(age);
				System.out.println(state);
				System.out.println();
			}
			bufferedReader.close();
			
		}
		catch(FileNotFoundException ex) {
			System.out.println("Can't find the file at :"
					+ file);
		}
		catch(IOException ex) {
			System.out.println("Error in reading the file");
		}
	}
}
