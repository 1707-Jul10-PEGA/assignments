package com.jntm.q20.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {

		//Identify the filepath
		String filepath = "src\\com\\jntm\\q20\\driver\\Data.txt";

		//Initialize fileReader
		FileReader fileReader = null;
		
		//Open the file in a TC block
		try {
			fileReader = new FileReader(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldn't find Data.txt");
		}

		// Wrap FileReader in BufferedReader.
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		//Init string and tokenizer for later
		String line = null;
		StringTokenizer st;

		//TC block around reading the data from the file.
		try {
			//While there are still lines, read new lines
			while ((line = bufferedReader.readLine()) != null) {
				//Tokenize the line
				st = new StringTokenizer(line);

				//Format the output
				System.out.println("Name: " + st.nextToken(":")+" "+ st.nextToken(":") + "\nAge: " + st.nextToken(":") + "\nState: "
						+ st.nextToken(":") + " State\n");

			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("ReadLine Failed.");
		}

		//Close the streams
		try {
			fileReader.close();
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not close bufferedReader.");
		}

	}

}
