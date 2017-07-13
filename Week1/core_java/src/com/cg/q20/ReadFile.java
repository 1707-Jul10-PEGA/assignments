package com.cg.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

	public static void main(String[] args) {
		String filename = "/Users/carlosgastelum/Documents/Revature/assignments/Week1/core_java/src/com/cg/q20/Data.txt";
		String temp;
		String firstName = null;
		String lastName = null;
		String age = null;
		String state = null;
		ArrayList<String> fileContent = new ArrayList<String>();

		try (BufferedReader input = new BufferedReader(new FileReader(filename))) {

			while ((temp = input.readLine()) != null) {
				fileContent.add(temp);
			}
			input.close();

		} catch (FileNotFoundException e) {
			System.err.println("File not found.");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

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