package com.cg.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	//Variables
	private String fileLocation;
	private String temp;
	private String firstName;
	private String lastName;
	private String age;
	private String state;
	private ArrayList<String> fileContent;
	
	//Constructor
	public ReadFile(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	
	/*
	 * Open and read file line by line using BufferedReader
	 * save content to an ArrayList of strings
	 * 
	 */
	public void openFile() {
		fileContent = new ArrayList<String>();
		
		try (BufferedReader input = new BufferedReader(new FileReader(fileLocation))) {

			while ((temp = input.readLine()) != null) {
				fileContent.add(temp);
			}
			input.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/*
	 * Use string split method to split the strings 
	 * every time it encounters a semicolon
	 */
	public void displayFileContent() {
		//Iterate through the strings
		for (String i : fileContent) {

			String[] string = i.split(":");

			for (int j = 0; j < string.length; j++) {
				if (j == 0) {
					firstName = string[j];
				} else if (j == 1) {
					lastName = string[j];
				} else if (j == 2) {
					age = string[j];
				} else {
					state = string[j];
				}

			}
			//Ensure that the string contain something
			if (firstName != null && lastName != null && age != null && state != null) {
				System.out.println("Name: " + firstName + " " + lastName);
				System.out.println("Age: " + age + " years");
				System.out.println("State: " + state + " State");
				System.out.println();
			}else{
				System.out.println("Check file.");
			}
		}
	}
}